package com.groupesan.project.java.scrumsimulator.mainpackage.ui;

import com.formdev.flatlaf.FlatLightLaf;
import com.groupesan.project.java.scrumsimulator.mainpackage.impl.UserStory;
import com.groupesan.project.java.scrumsimulator.mainpackage.impl.UserStoryFactory;
import com.groupesan.project.java.scrumsimulator.mainpackage.impl.UserStoryStore;
import com.groupesan.project.java.scrumsimulator.mainpackage.ui.panels.DemoPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {
  public App() {}

  public void start() {
    this.loadTheme();
    SwingUtilities.invokeLater(
        new Runnable() {
          @Override
          public void run() {
            // Initialize User Stories in helper function now
            initializeUserStories();

            // Load DemoPane
            DemoPane form = new DemoPane();
            form.setVisible(true);
          }
        });
  }

  private void initializeUserStories() {
    UserStory a =
        UserStoryFactory.getInstance()
            .createNewUserStory("predefinedUS1", "description1", 1.0, "new");
    a.doRegister();
    UserStoryStore.getInstance().addUserStory(a);
    UserStory b =
        UserStoryFactory.getInstance()
            .createNewUserStory("predefinedUS2", "description2", 2.0, "in progress");
    b.doRegister();
    UserStoryStore.getInstance().addUserStory(b);
    UserStory c =
        UserStoryFactory.getInstance()
            .createNewUserStory("predefinedUS3", "description3", 3.0, "completed");
    c.doRegister();
    UserStoryStore.getInstance().addUserStory(c);
  }

  private void loadTheme() {
    try {
      // TODO support setting theme from a configuration file
      UIManager.setLookAndFeel(new FlatLightLaf());
    } catch (UnsupportedLookAndFeelException e) {
      throw new RuntimeException(e);
    }
  }
}
