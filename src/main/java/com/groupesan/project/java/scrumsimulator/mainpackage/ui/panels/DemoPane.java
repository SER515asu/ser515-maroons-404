package com.groupesan.project.java.scrumsimulator.mainpackage.ui.panels;

import com.groupesan.project.java.scrumsimulator.mainpackage.core.Player;
import com.groupesan.project.java.scrumsimulator.mainpackage.core.ScrumRole;
import com.groupesan.project.java.scrumsimulator.mainpackage.impl.ProductBacklogStore;
import com.groupesan.project.java.scrumsimulator.mainpackage.impl.UserStory;
import com.groupesan.project.java.scrumsimulator.mainpackage.state.SimulationManager;
import com.groupesan.project.java.scrumsimulator.mainpackage.state.SimulationStateManager;
import com.groupesan.project.java.scrumsimulator.mainpackage.ui.utils.WizardManager;
import com.groupesan.project.java.scrumsimulator.mainpackage.ui.widgets.BaseComponent;
import com.groupesan.project.java.scrumsimulator.mainpackage.utils.CustomConstraints;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DemoPane extends JFrame implements BaseComponent {
  private Player player = new Player("bob", new ScrumRole("demo"));
  private JLabel welcomeLabel;

  public DemoPane() {
    this.init();
    player.doRegister();
  }

  public String getWelcomeLabelText() {
    return welcomeLabel.getText();
  }

  public void setWelcomeLabelText(String text) {
    welcomeLabel.setText(text);
  }

  public void updateRoleLabel(String role) {
    welcomeLabel.setText("Hello " + role + "!");
  }

  /**
   * Initialization of Demo Pane. Demonstrates creation of User stories, Sprints, and Simulation
   * start.
   */
  public void init() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Demo");
    setSize(1200, 300);

    GridBagLayout myGridbagLayout = new GridBagLayout();
    JPanel myJpanel = new JPanel();
    myJpanel.setBorder(new EmptyBorder(10, 10, 10, 10));
    myJpanel.setLayout(myGridbagLayout);

    welcomeLabel = new JLabel();
    welcomeLabel.setText("Hello !");
    myJpanel.add(
        welcomeLabel,
        new CustomConstraints(
            0, 0, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));

    JButton sprintsButton = new JButton("Sprints");
    sprintsButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            SprintListPane form = new SprintListPane();
            form.setVisible(true);
          }
        });

    SimulationStateManager simulationStateManager = new SimulationStateManager();
    SimulationPanel simulationPanel = new SimulationPanel(simulationStateManager);
    myJpanel.add(
        simulationPanel,
        new CustomConstraints(
            2, 1, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));

    myJpanel.add(
        sprintsButton,
        new CustomConstraints(
            0, 1, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));

    JButton userStoriesButton = new JButton("User Stories");
    userStoriesButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            UserStoryListPane form = new UserStoryListPane();
            form.setVisible(true);
          }
        });

    myJpanel.add(
        userStoriesButton,
        new CustomConstraints(
            1, 1, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));

    JButton updateStoryStatusButton = new JButton("Update User Story Status");
    updateStoryStatusButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            UpdateUserStoryPanel form = new UpdateUserStoryPanel();
            form.setVisible(true);
          }
        });
    JButton productBacklogButton = new JButton("Product Backlog");
    JButton fineTuneProbabilityButton = new JButton("Fine Tune Probability");
    myJpanel.add(
        fineTuneProbabilityButton,
        new CustomConstraints(
            1, 3, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));
    fineTuneProbabilityButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {

            // Open a window on button click
            JFrame newFrame = new JFrame("Fine Tune Probability");
            newFrame.setSize(1100, 100);
            newFrame.setVisible(true);
            newFrame.setLocationRelativeTo(null);

            // Display a window with two buttons
            JPanel twoButtonWindow = new JPanel();
            twoButtonWindow.setLayout(new GridLayout(1, 2, 10, 10));
            twoButtonWindow.setBorder(new EmptyBorder(10, 10, 10, 10));

            // Two buttons for the window
            JLabel label =
                new JLabel("Please select from the available choices to configure probability.\n");

            JButton blockerSetButton = new JButton("Blocker");
            JButton solutionSetButton = new JButton("Solution");

            twoButtonWindow.add(label);
            twoButtonWindow.add(blockerSetButton);
            twoButtonWindow.add(solutionSetButton);

            newFrame.add(twoButtonWindow);
          }
        });
    myJpanel.add(
        productBacklogButton,
        new CustomConstraints(
            3, 2, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));
    productBacklogButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {

            // Open a new window on button click
            JFrame newWindow = new JFrame("Product Backlog");
            newWindow.setSize(300, 500);
            newWindow.setVisible(true);
            // Display all the user stories in the window

            JPanel panel = new JPanel();

            List<UserStory> listOfUserStories =
                ProductBacklogStore.getInstance().getUserStoriesFromProductBacklog();
            panel.setLayout(new GridLayout(listOfUserStories.size(), 1, 10, 10));
            panel.setBorder(new EmptyBorder(10, 10, 10, 10));

            for (UserStory userStory : listOfUserStories) {
              JCheckBox chinButton = new JCheckBox(userStory.getName());
              panel.add(chinButton);
            }
            newWindow.add(panel);
            int heightForWindow = 90 + (listOfUserStories.size() * 10);
            newWindow.setSize(250, heightForWindow);
          }
        });
    myJpanel.add(
        updateStoryStatusButton,
        new CustomConstraints(
            3, 1, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));

    // Simulation button for Demo
    JButton simulationButton = new JButton("Add Developer");
    simulationButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            SimulationPane simulationPane = new SimulationPane();
            simulationPane.setVisible(true);
          }
        });

    myJpanel.add(
        simulationButton,
        new CustomConstraints(
            7, 1, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));

    // Modify Simulation button
    JButton modifySimulationButton = new JButton("Modify Simulation");
    modifySimulationButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            SimulationManager simulationManager = new SimulationManager();
            ModifySimulationPane modifySimulationPane = new ModifySimulationPane(simulationManager);
            modifySimulationPane.setVisible(true);
          }
        });

    // Add the button to the panel
    myJpanel.add(
        modifySimulationButton,
        new CustomConstraints(
            5, 1, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));

    // *** Role Selection now through SimulationUI ***
    // JButton roleSelectionButton = new JButton("Role Selection");
    // roleSelectionButton.addActionListener(
    //         new ActionListener() {
    //             @Override
    //             public void actionPerformed(ActionEvent e) {
    //                 RoleSelectionPane roleSelectionPane = new RoleSelectionPane();
    //                 roleSelectionPane.setVisible(true);
    //             }
    //         });

    // myJpanel.add(
    //         roleSelectionButton,
    //         new CustomConstraints(
    //                 4, 0, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));
    // *** Role Selection now through SimulationUI ***

    // Join Simulation button
    JButton joinSimulationButton = new JButton("Join Simulation");
    joinSimulationButton.addActionListener(
        e -> {
          SimulationUI simulationUserInterface = new SimulationUI();
          simulationUserInterface.setVisible(true);
        });

    myJpanel.add(
        joinSimulationButton,
        new CustomConstraints(
            6, 1, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));

    // Simulation button for Demo
    JButton simulationSwitchRoleButton = new JButton("Switch Role");
    simulationSwitchRoleButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            SimulationSwitchRolePane feedbackPanelUI = new SimulationSwitchRolePane(DemoPane.this);
            feedbackPanelUI.switchRole(DemoPane.this);
            feedbackPanelUI.setVisible(true);
          }
        });

    myJpanel.add(
        simulationSwitchRoleButton,
        new CustomConstraints(
            1, 2, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));

    // New button for Variant Simulation UI
    JButton variantSimulationUIButton = new JButton("Variant Simulation UI");
    variantSimulationUIButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            VariantSimulationUI variantSimulationUI = new VariantSimulationUI();
            variantSimulationUI.setVisible(true);
          }
        });

    // Adding the button to the panel
    myJpanel.add(
        variantSimulationUIButton,
        new CustomConstraints(
            3, 1, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));

    JButton SprintUIButton = new JButton("US Selection UI");
    SprintUIButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            // Load SprintUIPane
            SprintUIPane sprintUIPane = new SprintUIPane(player);
            sprintUIPane.setVisible(true);
          }
        });

    // Adding the button to the panel
    myJpanel.add(
        SprintUIButton,
        new CustomConstraints(
            8, 1, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));

    JButton newSimulationButton = new JButton("Create New Simulation");
    myJpanel.add(
        newSimulationButton,
        new CustomConstraints(
            2, 2, GridBagConstraints.WEST, 1.0, 1.0, GridBagConstraints.HORIZONTAL));

    newSimulationButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            WizardManager.get().showSimulationWizard();
          }
        });

    add(myJpanel);
  }
}
