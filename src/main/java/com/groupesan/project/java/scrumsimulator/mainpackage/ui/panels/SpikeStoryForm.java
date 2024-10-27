package com.groupesan.project.java.scrumsimulator.mainpackage.ui.panels;

import com.groupesan.project.java.scrumsimulator.mainpackage.impl.UserStory;
import com.groupesan.project.java.scrumsimulator.mainpackage.impl.UserStoryStore;
import com.groupesan.project.java.scrumsimulator.mainpackage.ui.widgets.BaseComponent;
import com.groupesan.project.java.scrumsimulator.mainpackage.utils.CustomConstraints;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SpikeStoryForm extends JFrame implements BaseComponent {

  Double[] effortPointsList = {1.0, 2.0, 3.0, 5.0, 8.0, 11.0, 19.0, 30.0, 49.0};

  public SpikeStoryForm() {
    this.init();
  }

  private JComboBox<String> developerCombo = new JComboBox<>();
  private JComboBox<Double> effortPointsCombo = new JComboBox<>(effortPointsList);
  private JComboBox<String> blockingStoryCombo = new JComboBox<>(getUserStories());
  private JButton submitButton = new JButton("Submit");

  public void init() {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setTitle("Spike Story");
    setSize(500, 400);

    GridBagLayout myGridbagLayout = new GridBagLayout();
    JPanel myJpanel = new JPanel();
    myJpanel.setBorder(new EmptyBorder(10, 10, 10, 10));
    myJpanel.setLayout(myGridbagLayout);

    // Developers Working label and dropdown
    JLabel developerLabel = new JLabel("Developers Working:");
    myJpanel.add(
        developerLabel,
        new CustomConstraints(0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL));
    myJpanel.add(
        developerCombo,
        new CustomConstraints(
            1, 0, GridBagConstraints.EAST, 1.0, 0.0, GridBagConstraints.HORIZONTAL));

    // Effort Points label and dropdown
    JLabel effortPointsLabel = new JLabel("Effort Points:");
    myJpanel.add(
        effortPointsLabel,
        new CustomConstraints(0, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL));
    myJpanel.add(
        effortPointsCombo,
        new CustomConstraints(
            1, 1, GridBagConstraints.EAST, 1.0, 0.0, GridBagConstraints.HORIZONTAL));

    // Select Blocking Story label and dropdown
    JLabel blockingStoryLabel = new JLabel("Select Blocking Story:");
    myJpanel.add(
        blockingStoryLabel,
        new CustomConstraints(0, 2, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL));
    myJpanel.add(
        blockingStoryCombo,
        new CustomConstraints(
            1, 2, GridBagConstraints.EAST, 1.0, 0.0, GridBagConstraints.HORIZONTAL));

    // Submit and Cancel buttons
    JButton cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(e -> this.dispose()); // Corrected the dispose call

    // Set Submit button to be inactive initially
    submitButton.setEnabled(false);
    submitButton.addActionListener(e -> handleSubmit());

    myJpanel.add(
        cancelButton,
        new CustomConstraints(0, 3, GridBagConstraints.EAST, GridBagConstraints.NONE));
    myJpanel.add(
        submitButton,
        new CustomConstraints(1, 3, GridBagConstraints.WEST, GridBagConstraints.NONE));

    add(myJpanel);
  }

  // Fetch existing user stories from UserStoryStore
  private String[] getUserStories() {
    UserStoryStore userStoryStore = UserStoryStore.getInstance();

    // Get the list of existing user stories
    List<UserStory> userStories = userStoryStore.getUserStories();

    // Extract names from UserStory objects
    return userStories.stream()
        .map(UserStory::getName) // Using getName() to get the user story name
        .toArray(String[]::new);
  }

  // Handle submit action
  private void handleSubmit() {
    // Handle form submission logic here
    this.dispose(); // Close the form for now
  }
}
