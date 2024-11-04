package com.groupesan.project.java.scrumsimulator.mainpackage.state;

import com.groupesan.project.java.scrumsimulator.mainpackage.impl.UserStory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JPanel;

public class UserStoryStateManagerTest {

    private UserStory blockedUserStory;
    private UserStory blockingUserStory;

    @Test
    public void testUpdateBlockingUserStoryStatusToInProgress() {
        blockingUserStory = new UserStory("US #2: Blocking Story", "This story blocks another", 3.0, 5.0, "new", null);
        blockedUserStory = new UserStory("US #1: Blocked Story", "This story is blocked", 5.0, 8.0, "new", blockingUserStory);

        // Set up parameters for the updateUserStoryStatus method
        String selectedUserStory = "US #1 : Blocked Story";
        String selectedStatus = "blocker";
        String selectedBlockingUserStory = "US #2 : Blocking Story";
        JPanel panel = new JPanel();
        String newStatus = "in progress";

        // Call the method to update the blocking user story's status
        UserStoryStateManager.updateUserStoryStatus(
                selectedUserStory,
                selectedStatus,
                selectedBlockingUserStory,
                panel,
                newStatus
        );

        // Assert that the blocking user's status is now "in progress"
        assertEquals("in progress", blockingUserStory.getStatus(), "The blocking user story's status should be updated to in progress");
    }
}