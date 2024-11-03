package com.groupesan.project.java.scrumsimulator.mainpackage.impl;

import java.util.ArrayList;
import java.util.List;

public class DeveloperStoreTest {
  DeveloperStore developerStore;

  @Test
  public void setterAndGetter() {
    developerStore = DeveloperStore.getInstance();

    List<String> developerList = new ArrayList<>();
    developerStore.setDeveloperList(developerList);
    assertTrue(developerStore.getDeveloperList().size() == 0);
  }

  private void assertTrue(boolean b) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
  }
}
