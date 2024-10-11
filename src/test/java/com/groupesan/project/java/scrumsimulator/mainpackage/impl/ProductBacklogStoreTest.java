package com.groupesan.project.java.scrumsimulator.mainpackage.impl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class ProductBacklogStoreTest {
    ProductBacklogStore productbacklog ;
    @BeforeEach 
    public void setup(){
        productbacklog = ProductBacklogStore.getInstance();
    }  

    @Test
    public void getUserStoriesFromProductBacklogTest(){
        productbacklog.getUserStoriesFromProductBacklog();
        try (MockedStatic<UserStoryStore> mockedStore = mockStatic(UserStoryStore.class)) {
            UserStoryStore mockUserStoryStore = mock(UserStoryStore.class);
            List<UserStory> userstorieslist = new ArrayList<UserStory>();
            UserStory userstory = new UserStory("new", 0);
           // when(mockUserStoryStore.getUserStories()).thenReturn();
            mockedStore.when(UserStoryStore::getInstance).thenReturn(mockUserStoryStore);
    }
}
