package com.groupesan.project.java.scrumsimulator.mainpackage.impl;

import java.util.List;

public class SpikeStory {

  public static void createSpikeStory(
      List<String> developerList, Double pointsValue, String userStoryName) {
    UserStory blockedUserStory = null;
    for (UserStory userStoryLoop : UserStoryStore.getInstance().getUserStories()) {
      if (userStoryLoop.getName().equalsIgnoreCase(userStoryName)) {
        blockedUserStory = userStoryLoop;
        break;
      }
    }

    UserStory userStory =
        new UserStory(
            "Spike Story",
            "This is a spike story,created when a user story is blocked by another one",
            pointsValue,
            blockedUserStory.getBusinessValue(),
            "in progress",
            null);
    userStory.doRegister();
    List<UserStory> userStoryList = UserStoryStore.getInstance().getUserStories();
    userStoryList.add(userStory);
    UserStoryStore.getInstance().setUserStories(userStoryList);
  }
}
