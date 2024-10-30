package com.groupesan.project.java.scrumsimulator.mainpackage.ui.panels;

import com.groupesan.project.java.scrumsimulator.mainpackage.impl.DeveloperStore;
import com.groupesan.project.java.scrumsimulator.mainpackage.utils.CustomConstraints;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

/**
 * SimulationPane is a part of the UI in the scrum simulator.
 *
 * <p>Todo: logic/controller portions of original FeedbackPanel.java
 *
 * @version 0.1
 * @since 2023-11-8
 */
public class SimulationPane extends JFrame {
  private JButton joinButton;
  private JPopupMenu developerNameField;
  private JRadioButton playerRadioButton;
  private JRadioButton teacherRadioButton;
  private ButtonGroup typeButtonGroup;
  private JComboBox<String> roleComboBox;

  private static final List<String> allowedRoleNames =
      Arrays.asList("pig", "chicken", "product owner", "scrum master");

  /** The simulation Pane for adding new users. */
  public SimulationPane() {
    setTitle("Simulation Status");
    setSize(400, 200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout());

    JLabel developerLabel = new JLabel("Developer Name:");

    developerNameField = new JPopupMenu();
    List<String> devList = DeveloperStore.getInstance().getDeveloperList();
    for (String developerName : devList) {
      JCheckBox jCheckBox = new JCheckBox(developerName);
      developerNameField.add(jCheckBox);
    }

    JButton dropdownButton = new JButton("Select Options");
    dropdownButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            developerNameField.show(dropdownButton, 3, dropdownButton.getHeight());
          }
        });
    panel.setBorder(new EmptyBorder(50, 10, 50, 10));

    panel.add(
        developerLabel,
        new CustomConstraints(
            1, 0, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));
    panel.add(
        dropdownButton,
        new CustomConstraints(
            3, 0, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));
    panel.add(
        developerNameField,
        new CustomConstraints(
            3, 1, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));

    joinButton = new JButton("Add Developer");
    joinButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            // Logic for join button
            // onJoinButtonClicked();
          }
        });

    setLayout(new BorderLayout());
    add(panel);
  }

  // private void onJoinButtonClicked() {
  // String username = developerNameField.getText();
  /*String type = playerRadioButton.isSelected() ? "player" : "teacher";
  String roleName = roleComboBox.getSelectedItem().toString();*/

  // if (username.isEmpty()) {
  //   JOptionPane.showMessageDialog(
  //       null, "Developer name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
  //   return;
  // }

  // AddUser.addUser(username);
  // clearFields();
}

  // private void clearFields() {
  //   developerNameField.setText("");
  //   // typeButtonGroup.clearSelection();
  //   // roleComboBox.setSelectedIndex(0);
  // }
