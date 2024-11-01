package com.groupesan.project.java.scrumsimulator.mainpackage.ui.panels;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimulationSwitchRolePaneTest {

  private DemoPane demoPane;
  private SimulationSwitchRolePane switchRolePane;

  @BeforeEach
  void setup() {
    demoPane = new DemoPane();
    switchRolePane = new SimulationSwitchRolePane(demoPane);
  }

  @Test
  void testInitialRole() {
    assertEquals("", switchRolePane.getCurrentRole(), "Initial role should be Null.");
    assertEquals(
        "Hello !", demoPane.getWelcomeLabelText(), "Initial label text should be 'Hello !'.");
  }

  @Test
  void testSwitchToDeveloperRole() {
    switchRolePane.developerRadioButton.setSelected(true);
    switchRolePane.switchRole(demoPane);
    assertEquals("Developer", switchRolePane.getCurrentRole());
    assertEquals("Hello Developer!", demoPane.getWelcomeLabelText());
  }

  @Test
  void testSwitchToScrumMasterRole() {
    switchRolePane.scrumMasterRadioButton.setSelected(true);
    switchRolePane.switchRole(demoPane);
    assertEquals(
        "Scrum Master", switchRolePane.getCurrentRole(), "Role should be set to Scrum Master.");
    assertEquals(
        "Hello Scrum Master!",
        demoPane.getWelcomeLabelText(),
        "Label should reflect 'Hello Scrum Master!'.");
  }

  @Test
  void testSwitchToProductOwnerRole() {
    switchRolePane.productOwnerRadioButton.setSelected(true);
    switchRolePane.switchRole(demoPane);
    assertEquals(
        "Product Owner", switchRolePane.getCurrentRole(), "Role should be set to Product Owner.");
    assertEquals(
        "Hello Product Owner!",
        demoPane.getWelcomeLabelText(),
        "Label should reflect 'Hello Product Owner!'.");
  }

  @Test
  void testClearRoleSelection() {
    switchRolePane.switchRole(demoPane);
    assertEquals("", switchRolePane.getCurrentRole(), "Cleared selection defaults to Null.");
  }
}
