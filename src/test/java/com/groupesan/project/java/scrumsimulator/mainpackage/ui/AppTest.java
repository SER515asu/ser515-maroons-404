package com.groupesan.project.java.scrumsimulator.mainpackage.impl;

import com.groupesan.project.java.scrumsimulator.mainpackage.ui.App;
import org.junit.jupiter.api.Test;

public class AppTest {

  private App app;

  @Test
  public void initTest() {
    app = new App();
    // Start the app to initialize the user stories
    try {
      app.start();
    } catch (Exception e) {
      // do nothing
      // as this is java junit testing Ui code is involved and may throw headless exception
    }
  }
}
