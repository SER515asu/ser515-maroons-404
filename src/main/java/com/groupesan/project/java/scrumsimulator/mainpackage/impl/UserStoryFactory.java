package com.groupesan.project.java.scrumsimulator.mainpackage.impl;

public class UserStoryFactory {

    private static UserStoryFactory userStoryFactory;

    public static UserStoryFactory getInstance() {
        if (userStoryFactory == null) {
            userStoryFactory = new UserStoryFactory();
        }
        return userStoryFactory;
    }

    private UserStoryFactory() {}

    public UserStory createNewUserStory(String name, String description, double pointValue, String status) {
        UserStory newUS = new UserStory(name, description, pointValue, status);
        return newUS;
    }
}
