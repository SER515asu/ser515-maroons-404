package com.groupesan.project.java.scrumsimulator.mainpackage.ui.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SpikeStoryForm extends JFrame {
  public SpikeStoryForm() {
    // Set the title and size to match NewUserStoryForm
    setTitle("Spike Story");
    setSize(500, 400);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    // Main panel setup using GridBagLayout
    JPanel mainPanel = new JPanel(new GridBagLayout());
    mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding around the panel
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5); // Padding around components
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.WEST;

    // Developers Working label
    JLabel developerLabel = new JLabel("Developers Working:");
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    mainPanel.add(developerLabel, gbc);

    // Developers Working dropdown
    JComboBox<String> developerComboBox = new JComboBox<>(); // Empty dropdown
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    mainPanel.add(developerComboBox, gbc);

    // Effort Points label
    JLabel effortPointsLabel = new JLabel("Effort Points:");
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    mainPanel.add(effortPointsLabel, gbc);

    // Effort Points dropdown (same as Points in NewUserStoryForm)
    Double[] effortPointsOptions = {1.0, 2.0, 3.0, 5.0, 8.0, 11.0, 19.0, 30.0, 49.0};
    JComboBox<Double> effortPointsComboBox = new JComboBox<>(effortPointsOptions);
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.gridwidth = 2;
    mainPanel.add(effortPointsComboBox, gbc);

    // Submit and Cancel buttons
    JPanel buttonPanel = new JPanel(new GridBagLayout());
    JButton cancelButton = new JButton("Cancel");
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    buttonPanel.add(cancelButton, gbc);

    JButton submitButton = new JButton("Submit");
    gbc.gridx = 1;
    gbc.gridy = 0;
    buttonPanel.add(submitButton, gbc);

    // ActionListener for the Cancel button
    cancelButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            dispose(); // Close the form when Cancel is clicked
          }
        });

    // Add main panel and button panel to the frame
    setLayout(new GridBagLayout());
    gbc.gridx = 0;
    gbc.gridy = 0;
    add(mainPanel, gbc);

    gbc.gridy = 1;
    add(buttonPanel, gbc);
  }
}
