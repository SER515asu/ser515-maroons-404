package com.groupesan.project.java.scrumsimulator.mainpackage.ui.panels;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.junit.jupiter.api.Test;

public class DemoPaneTest {

  @Test
  public void testPaneExistence() {

    try {
      Class.forName("com.groupesan.project.java.scrumsimulator.mainpackage.ui.panels.DemoPane");
      assertTrue(true, "DemoPane class exists");
    } catch (ClassNotFoundException e) {
      assertTrue(false, "DemoPane class does not exist");
    }
  }

  @Test
  public void testCreateNewSimulationButtonExists() {

    DemoPane demoPane = new DemoPane();
    Component[] components = demoPane.getContentPane().getComponents();
    JPanel myJpanel = null;

    for (Component component : components) {
      if (component instanceof JPanel) {
        myJpanel = (JPanel) component;
        break;
      }
    }
    assertNotNull(myJpanel, "'myJpanel' should exist in DemoPane.");
    Component[] panelComponents = myJpanel.getComponents();
    JButton newSimulationButton = null;
    for (Component component : panelComponents) {
      if (component instanceof JButton) {
        JButton button = (JButton) component;
        if (button.getText().equals("Create New Simulation")) {
          newSimulationButton = button;
          break;
        }
      }
    }
    assertNotNull(newSimulationButton, "'Create New Simulation' button should exist in myJpanel.");
  }

  private JButton findButtonByText(DemoPane pane, String text) {
    for (java.awt.Component component : pane.getContentPane().getComponents()) {
      if (component instanceof JButton) {
        JButton button = (JButton) component;
        if (button.getText().equals(text)) {
          return button;
        }
      }
    }
    return null;
  }
}
