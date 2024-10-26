package com.groupesan.project.java.scrumsimulator.mainpackage.ui.panels;

import com.groupesan.project.java.scrumsimulator.mainpackage.impl.UserStory;
import com.groupesan.project.java.scrumsimulator.mainpackage.impl.UserStoryStore;
import com.groupesan.project.java.scrumsimulator.mainpackage.state.UserStoryStateManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class UpdateUserStoryPanel extends JFrame {

  public UpdateUserStoryPanel() {
    init();
  }

  private void init() {
    setTitle("Update User Story Status");
    setSize(400, 200);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel panel = new JPanel();
    placeComponents(panel);
    add(panel);

    setLocationRelativeTo(null);
  }

  private void placeComponents(JPanel panel) {
    panel.setLayout(null);

    JLabel userStoryLabel = new JLabel("Select User Story:");
    userStoryLabel.setBounds(10, 20, 120, 25);
    panel.add(userStoryLabel);

    List<UserStory> userStories = UserStoryStore.getInstance().getUserStories();
    // display user story id and name
    List<String> displayUserStories = new ArrayList<String>();
    displayUserStories.add("");
    for (UserStory userStory : userStories) {
      String item = userStory.getId() + " : " + userStory.getName();
      displayUserStories.add(item);
    }

    JComboBox<String> userStoryComboBox =
        new JComboBox<>(displayUserStories.toArray(new String[0]));
    userStoryComboBox.setSelectedItem("Please select user story");
    userStoryComboBox.setBounds(150, 20, 200, 25);
    panel.add(userStoryComboBox);

    JLabel statusLabel = new JLabel("Select Status:");
    statusLabel.setBounds(10, 50, 120, 25);
    panel.add(statusLabel);

    String[] statusOptions = {"new", "in progress", "ready for test", "completed", "blocker"};
    JComboBox<String> statusComboBox = new JComboBox<>(statusOptions);
    statusComboBox.setBounds(150, 50, 200, 25);
    panel.add(statusComboBox);

    JButton updateButton = new JButton("Update Status");
    updateButton.setBounds(150, 120, 150, 25);
    panel.add(updateButton);

    JLabel blockingUserStoryLabel = new JLabel("Blocking User Story:");
    blockingUserStoryLabel.setBounds(10, 80, 120, 25);
    panel.add(blockingUserStoryLabel);

    List<UserStory> blockingUserStories = UserStoryStore.getInstance().getUserStories();
    List<String> displayBlockingUserStories = new ArrayList<String>();
    displayBlockingUserStories.add("");
    for (UserStory userStory : blockingUserStories) {
      String blockingItem = userStory.getId() + " : " + userStory.getName();
      displayBlockingUserStories.add(blockingItem);
    }

    JComboBox<String> blockingUserStoryComboBox =
        new JComboBox<>(displayBlockingUserStories.toArray(new String[0]));
    blockingUserStoryComboBox.setSelectedItem("Please select a blocking user story");
    blockingUserStoryComboBox.setBounds(150, 80, 200, 25);
    panel.add(blockingUserStoryComboBox);

    updateButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String selectedUserStory = (String) userStoryComboBox.getSelectedItem();
            System.out.println(selectedUserStory);
            String selectedStatus = (String) statusComboBox.getSelectedItem();
            System.out.println(selectedStatus);
            if (selectedUserStory != null && selectedStatus != null) {
              int userStoryId =
                  Integer.parseInt(selectedUserStory.split(":")[0].split("#")[1].strip());
              if ("blocker".equals(selectedStatus)) {
                String selectedBlockingUserStory =
                    (String) blockingUserStoryComboBox.getSelectedItem();
                System.out.println(selectedBlockingUserStory);
                if (selectedBlockingUserStory == null
                    || selectedBlockingUserStory.trim().isEmpty()) {
                  JOptionPane.showMessageDialog(
                      panel,
                      "Please select a Blocking User Story",
                      "Validation Error",
                      JOptionPane.ERROR_MESSAGE);
                  System.out.println("Add a Blocking User Story to proceed");
                  return;
                }
              } // else selectedBlockingUserStory = null;
              UserStoryStateManager.updateUserStoryStatus(userStoryId, selectedStatus);
              JOptionPane.showMessageDialog(null, "Status updated successfully!");
              dispose();
            } else {
              JOptionPane.showMessageDialog(null, "Please select a User Story and Status");
            }
          }
        });
  }
}
