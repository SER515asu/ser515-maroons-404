package com.groupesan.project.java.scrumsimulator.mainpackage.ui.panels;

import com.groupesan.project.java.scrumsimulator.mainpackage.impl.UserStory;
import com.groupesan.project.java.scrumsimulator.mainpackage.impl.UserStoryStore;
import com.groupesan.project.java.scrumsimulator.mainpackage.ui.widgets.BaseComponent;
import com.groupesan.project.java.scrumsimulator.mainpackage.utils.CustomConstraints;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    JLabel developerLabel = new JLabel("Developers Working:");
    myJpanel.add(
        developerLabel,
        new CustomConstraints(0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL));
    myJpanel.add(
        developerCombo,
        new CustomConstraints(
            1, 0, GridBagConstraints.EAST, 1.0, 0.0, GridBagConstraints.HORIZONTAL));

    JLabel effortPointsLabel = new JLabel("Effort Points:");
    myJpanel.add(
        effortPointsLabel,
        new CustomConstraints(0, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL));
    myJpanel.add(
        effortPointsCombo,
        new CustomConstraints(
            1, 1, GridBagConstraints.EAST, 1.0, 0.0, GridBagConstraints.HORIZONTAL));

    JLabel blockingStoryLabel = new JLabel("Select Blocking Story:");
    myJpanel.add(
        blockingStoryLabel,
        new CustomConstraints(0, 2, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL));
    myJpanel.add(
        blockingStoryCombo,
        new CustomConstraints(
            1, 2, GridBagConstraints.EAST, 1.0, 0.0, GridBagConstraints.HORIZONTAL));

    JPanel buttonPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);

    JButton cancelButton = new JButton("Cancel");
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    buttonPanel.add(cancelButton, gbc);

    gbc.gridx = 1;
    gbc.gridy = 0;
    buttonPanel.add(submitButton, gbc);

    cancelButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            dispose();
          }
        });

    submitButton.addActionListener(e -> handleSubmit());

    myJpanel.add(
        buttonPanel,
        new CustomConstraints(0, 3, GridBagConstraints.CENTER, GridBagConstraints.NONE));

    add(myJpanel);
  }

  private String[] getUserStories() {
    UserStoryStore userStoryStore = UserStoryStore.getInstance();
    List<UserStory> userStories = userStoryStore.getUserStories();
    return userStories.stream().map(UserStory::getName).toArray(String[]::new);
  }

  private void handleSubmit() {
    System.out.println("Spike Story submitted!");
    dispose();
  }
}
