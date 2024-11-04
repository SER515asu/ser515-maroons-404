
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
            .createNewUserStory("predefinedUS1", "description1", 1.0, 1.0, "new");
    a.doRegister();
    UserStoryStore.getInstance().addUserStory(a);

    UserStory b =
        UserStoryFactory.getInstance()
            .createNewUserStory("predefinedUS2", "description2", 2.0, 2.0, "in progress");
    b.doRegister();
    UserStoryStore.getInstance().addUserStory(b);

    UserStory c =
        UserStoryFactory.getInstance()
            .createNewUserStory("predefinedUS3", "description3", 3.0, 3.0, "completed");
    c.doRegister();
    UserStoryStore.getInstance().addUserStory(c);
    UserStory d =
        UserStoryFactory.getInstance()
            .createNewUserStory("predefinedUS4", "description1", 1.0, 1.0, "new");
    d.doRegister();
    UserStoryStore.getInstance().addUserStory(d);

    UserStory e =
        UserStoryFactory.getInstance()
            .createNewUserStory("predefinedUS5", "description1", 1.0, 1.0, "new");
    e.doRegister();
    UserStoryStore.getInstance().addUserStory(e);

    UserStory f =
        UserStoryFactory.getInstance()
            .createNewUserStory("predefinedUS6", "description1", 1.0, 1.0, "new");
    f.doRegister();
    UserStoryStore.getInstance().addUserStory(f);

    UserStory g =
        UserStoryFactory.getInstance()
            .createNewUserStory("predefinedUS7", "description1", 1.0, 1.0, "new");
    g.doRegister();
    UserStoryStore.getInstance().addUserStory(g);

    UserStory h =
        UserStoryFactory.getInstance()
            .createNewUserStory("predefinedUS8", "description1", 1.0, 1.0, "new");
    h.doRegister();
    UserStoryStore.getInstance().addUserStory(h);
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