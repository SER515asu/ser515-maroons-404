package com.groupesan.project.java.scrumsimulator.mainpackage.ui.panels;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.groupesan.project.java.scrumsimulator.mainpackage.impl.UserStory;
import com.groupesan.project.java.scrumsimulator.mainpackage.impl.UserStoryStore;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class EditUserStoryFormTest {

  private EditUserStoryForm editUserStoryForm;

  private UserStory userStory;

  @BeforeEach
  public void setUp() {
    // Setup mock UserStoryStore to return a mock list of user stories
    // Initialize the EditUserStoryForm with mocks
    UserStoryStore mockUserStoryStore = mock(UserStoryStore.class);

    // Mock the singleton's getInstance() method
    try (MockedStatic<UserStoryStore> mockedStore = mockStatic(UserStoryStore.class)) {

      // Setup mock user story behavior
      List<UserStory> userStories = new ArrayList<>();
      userStory = new UserStory("a", "desc", 1.0);
      userStory.doRegister();

      userStories.add(userStory);

      // Setup mock user stories list
      when(mockUserStoryStore.getUserStories()).thenReturn(userStories);

      mockedStore.when(UserStoryStore::getInstance).thenReturn(mockUserStoryStore);

      // Call the static method

      assertEquals(UserStoryStore.getInstance(), mockUserStoryStore);
      // Verify that the static method was called
      mockedStore.verify(UserStoryStore::getInstance);
      // Initialize the form
      editUserStoryForm = new EditUserStoryForm(userStory, null);
      // System.out.println(mockUserStoryStore);
      System.out.println(
          "Static method invoked: "
              + UserStoryStore.getInstance().getUserStories().get(0).getName());

      // Now you can perform tests with the mocked singleton behavior...
    }
  }

  @Test
  public void testDeleteButtonClick() {
    // Get the delete button
    try {
      JButton deleteButton = editUserStoryForm.getDeleteButton();
      // Simulate a click on the delete button
      deleteButton.doClick();
    } catch (Exception e) {
      // do nothing
      e.printStackTrace();
    }
  }
}
