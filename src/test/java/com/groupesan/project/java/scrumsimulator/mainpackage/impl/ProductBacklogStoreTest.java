package com.groupesan.project.java.scrumsimulator.mainpackage.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

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
            UserStory userstory1 = new UserStory("XYZ", "ABC",2.0,"new");
            userstory1.doRegister();
            
            UserStory userstory2 = new UserStory("Rachana Rocks", "That is not true",2.0,"completed");
            userstory2.doRegister();
            userstorieslist.add(userstory1);
            userstorieslist.add(userstory2);
            when(mockUserStoryStore.getUserStories()).thenReturn(userstorieslist);
            mockedStore.when(UserStoryStore::getInstance).thenReturn(mockUserStoryStore);
    }
}
}
