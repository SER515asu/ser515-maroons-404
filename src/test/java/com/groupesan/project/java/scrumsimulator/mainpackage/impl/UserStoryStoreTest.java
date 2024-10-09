package com.groupesan.project.java.scrumsimulator.mainpackage.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserStoryStoreTest {

  @Test
  public void testSetUserStories() {
    UserStory userStory = new UserStory("test", "setting user story from test class", 0.0);
    UserStoryStore.getInstance().addUserStory(userStory);
    assertTrue(
        UserStoryStore.getInstance().getUserStories().getLast().getName().equalsIgnoreCase("test"));
  }
}
