package com.groupesan.project.java.scrumsimulator.mainpackage.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserStoryStoreTest {

  UserStoryStore userStoryStore;

  @BeforeEach
  public void setUp() {
    userStoryStore = UserStoryStore.getInstance();
  }

  @Test
  public void testSetUserStories() {
    UserStory userStory = new UserStory("test", "setting user story from test class", 0.0, "new");
    List<UserStory> userStories = new ArrayList<>();
    userStories.add(userStory);
    userStoryStore.setUserStories(userStories);
  }

  @Test
  public void testAddUserStory() {
    userStoryStore.addUserStory(
        new UserStory("test", "setting user story from test class", 0.0, "new"));
  }

  @Test
  public void testRemoveUserStory() {
    UserStory userStory =
        new UserStory("test", "setting user story from test class", 0.0, "backlog");
    List<UserStory> userStories = new ArrayList<>();
    userStory.doRegister();
    userStories.add(userStory);

    userStoryStore.setUserStories(userStories);
    userStoryStore.removeUserStory(userStory);

    assertNotNull(userStoryStore.getUserStories());
  }
}
