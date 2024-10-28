package com.groupesan.project.java.scrumsimulator.mainpackage.ui.panels;

import com.groupesan.project.java.scrumsimulator.mainpackage.impl.AddUser;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

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
  private JTextField developernameField;
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
    panel.setLayout(new GridLayout(3, 2));

    JLabel usernameLabel = new JLabel("Developer Name:");
    developernameField = new JTextField(20);
    panel.add(usernameLabel);
    panel.add(developernameField);

    joinButton = new JButton("Add Developer");
    joinButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            // Logic for join button
            onJoinButtonClicked();
          }
        });

    setLayout(new BorderLayout());
    add(joinButton, BorderLayout.SOUTH);
    add(panel);
  }

  private void onJoinButtonClicked() {
    String username = developernameField.getText();
    String type = playerRadioButton.isSelected() ? "player" : "teacher";
    String roleName = roleComboBox.getSelectedItem().toString();

    if (username.isEmpty()) {
      JOptionPane.showMessageDialog(
          null, "Username cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
      return;
    }

    AddUser.addUser(username, type, roleName);
    clearFields();
  }

  private void clearFields() {
    developernameField.setText("");
    typeButtonGroup.clearSelection();
    roleComboBox.setSelectedIndex(0);
  }
}
