package com.groupesan.project.java.scrumsimulator.mainpackage.impl;

import java.util.ArrayList;
import java.util.List;

public class UserStoryStore {

  private static UserStoryStore userStoryStore;

  /**
   * returns the shared instance of the UserStoryStore which contains all user stories in the
   * system.
   *
   * @return
   */
  public static UserStoryStore getInstance() {
    if (userStoryStore == null) {
      userStoryStore = new UserStoryStore();
    }
    return userStoryStore;
  }

  private List<UserStory> userStories;

  private UserStoryStore() {
    userStories = new ArrayList<>();
  }

  public void addUserStory(UserStory userStory) {
    userStories.add(userStory);
  }

  public List<UserStory> getUserStories() {
    return new ArrayList<>(userStories);
  }

  public void setUserStories(List<UserStory> userStories) {
    this.userStories = userStories;
  }

  public void removeUserStory(UserStory userStory) {
    int index = -1;
    for (UserStory us : userStories) {
      if (us.getId().equals(userStory.getId())) {
        index = userStories.indexOf(us);
        break;
      }
    }
    userStories.remove(index);
    setUserStories(userStories);
  }

  public UserStory getUserStoryByName(String name) {
    for (UserStory story : userStories) {
      if (story.getName().equals(name)) {
        return story;
      }
    }
    return null; // Return null if not found
  }

  public void registerUserStory(UserStory userStory) {
    userStory.register(); // Calls the protected register() within the same package
    addUserStory(userStory); // Add the registered story to the store
  }

  public void updateUserStory(UserStory updatedStory) {
    for (int i = 0; i < userStories.size(); i++) {
      if (userStories.get(i).getName().equals(updatedStory.getName())) {
        userStories.set(i, updatedStory);
        return;
      }
    }

    userStories.add(updatedStory);
  }
}
