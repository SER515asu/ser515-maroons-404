package com.groupesan.project.java.scrumsimulator.mainpackage.ui.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
  private JButton addDeveloperButton;
  private JTextField usernameField;
  private List<String> developers;

  /** The simulation Pane for adding new users. */
  public SimulationPane() {
    setTitle("Simulation Status");
    setSize(400, 200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(4, 2));

    JLabel usernameLabel = new JLabel("Developer Name:");
    usernameField = new JTextField(20);
    panel.add(usernameLabel);
    panel.add(usernameField);
    developers = new ArrayList<>(Arrays.asList("Existing Developer 1", "Existing Developer 2"));

    addDeveloperButton = new JButton("Add Developer");
    addDeveloperButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            // Logic for adding developer button
            addDeveloperButton();
          }
        });

    setLayout(new BorderLayout());
    add(addDeveloperButton, BorderLayout.SOUTH);
    add(panel);
  }

  private void addDeveloperButton() {
    String username = usernameField.getText();

    if (!username.isEmpty()) {
      developers.add(username);
      JOptionPane.showMessageDialog(this, "Developer added successfully.");
    } else {
      JOptionPane.showMessageDialog(
          null, "Developer name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
      return;
    }

    // AddUser.addUser(username);
    // clearFields();
    dispose();
  }

  private void clearFields() {
    usernameField.setText("");
    // typeButtonGroup.clearSelection();
    // roleComboBox.setSelectedIndex(0);
  }
}
