package com.groupesan.project.java.scrumsimulator.mainpackage.ui.panels;


import com.groupesan.project.java.scrumsimulator.mainpackage.impl.DeveloperStore;
import com.groupesan.project.java.scrumsimulator.mainpackage.utils.CustomConstraints;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;

import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import javax.swing.JTextField;
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

  private JButton addDeveloperButton;
  private JTextField usernameField;
  private List<String> developers;

  private JButton joinButton;
  private JPopupMenu developerNameField;
  private JRadioButton playerRadioButton;
  private JRadioButton teacherRadioButton;
  private ButtonGroup typeButtonGroup;
  private JComboBox<String> roleComboBox;
  private int countOfDevelopers = 0;

  private static final List<String> allowedRoleNames =
      Arrays.asList("pig", "chicken", "product owner", "scrum master");

  /** The simulation Pane for adding new users. */
  public SimulationPane() {
    setTitle("Simulation Status");
    setSize(300, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel panel = new JPanel();
    GridBagLayout gridBagLayout = new GridBagLayout();
    panel.setLayout(gridBagLayout);


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

    JLabel developerLabel = new JLabel("Developer Name:");
    List<JCheckBox> checkBoxMenuItems = new ArrayList<>();
    joinButton = new JButton("Add Developer");
    JTextArea displayExistingDeveloperList = new JTextArea();

    StringBuilder existingDevelopers = new StringBuilder();
    for(String developer : DeveloperStore.getInstance().getDeveloperList()){
      countOfDevelopers++;
      existingDevelopers.append(developer).append("\n");
    }

    displayExistingDeveloperList.setText(existingDevelopers.toString());   

    
    developerNameField = new JPopupMenu();
    List<String> devList = DeveloperStore.getInstance().getDeveloperList();
    for (String developerName : devList) {
      JCheckBox jCheckBox = new JCheckBox(developerName);
      checkBoxMenuItems.add(jCheckBox);
      developerNameField.add(jCheckBox);
    }

    JButton dropdownButton = new JButton("Select Options");

    dropdownButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            developerNameField.show(dropdownButton, 0, dropdownButton.getHeight());
          }
        });
    //panel.setBorder(new EmptyBorder(50, 10, 50, 10));
    
    panel.add(
        developerLabel,
        new CustomConstraints(
            1, 0, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));
    panel.add(
        dropdownButton,
        new CustomConstraints(
            2, 0, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));
    
    panel.add(
        joinButton,
        new CustomConstraints(
          1, 4, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));
    panel.add(
            new JLabel("Developer List"),
            new CustomConstraints(
              1, 6, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));
          
    //displayExistingDeveloperList.setSize(300, 10);
    joinButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
           
            StringBuilder selectedOptions = new StringBuilder(displayExistingDeveloperList.getText());
            appendSelectedOptions(checkBoxMenuItems,selectedOptions,displayExistingDeveloperList);
            

          }
        });
    
    setLayout(new BorderLayout());

    add(addDeveloperButton, BorderLayout.SOUTH);
    add(panel);

    JPanel panel2 = new JPanel();
    displayExistingDeveloperList.setEditable(false);
    panel2.add(displayExistingDeveloperList);
    
    add(panel,BorderLayout.NORTH);
    add(panel2);


  }
  public void appendSelectedOptions(List<JCheckBox> checkBoxMenuItems,StringBuilder selectedOptions,JTextArea displayExistingDeveloperList ){
    List<String> newList = new ArrayList<>(DeveloperStore.getInstance().getDeveloperList());


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

    for (JCheckBox item : checkBoxMenuItems) {
      if (item.isSelected()) {
          countOfDevelopers++;
          newList.add(item.getText());

          selectedOptions.append(item.getText()).append("\n");
      }
      DeveloperStore.getInstance().setDeveloperList(newList);


  }
  
  displayExistingDeveloperList.setText(selectedOptions.toString());   
  Dimension dimension = new Dimension(200,(countOfDevelopers*10)+20);
  displayExistingDeveloperList.setPreferredSize(dimension);  // Width: 200px, Height: 30px

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
