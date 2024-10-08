package com.groupesan.project.java.scrumsimulator.mainpackage.ui.panels;

import com.groupesan.project.java.scrumsimulator.mainpackage.core.User;
import com.groupesan.project.java.scrumsimulator.mainpackage.impl.UserStory;
import com.groupesan.project.java.scrumsimulator.mainpackage.impl.UserStoryStore;
import com.groupesan.project.java.scrumsimulator.mainpackage.ui.widgets.BaseComponent;
import com.groupesan.project.java.scrumsimulator.mainpackage.utils.CustomConstraints;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EditUserStoryForm extends JFrame implements BaseComponent {

  Double[] pointsList = {1.0, 2.0, 3.0, 5.0, 8.0, 11.0, 19.0, 30.0, 49.0};
  private UserStoryListPane parentWindow = null;
  public EditUserStoryForm(UserStory userStory,UserStoryListPane parentWindow) {
    this.userStory = userStory;
    this.parentWindow = parentWindow;
    this.init();
  }

  private UserStory userStory;

  private JTextField nameField = new JTextField();
  private JTextArea descArea = new JTextArea();
  private JComboBox<Double> pointsCombo = new JComboBox<>(pointsList);

  public void init() {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setTitle("Edit User Story " + userStory.getId().toString());
    setSize(400, 300);

    nameField = new JTextField(userStory.getName());
    descArea = new JTextArea(userStory.getDescription());
    pointsCombo = new JComboBox<>(pointsList);
    pointsCombo.setSelectedItem(userStory.getPointValue());

    GridBagLayout myGridbagLayout = new GridBagLayout();
    JPanel myJpanel = new JPanel();
    myJpanel.setBorder(new EmptyBorder(10, 10, 10, 10));
    myJpanel.setLayout(myGridbagLayout);

    BorderLayout myBorderLayout = new BorderLayout();

    setLayout(myBorderLayout);

    JLabel nameLabel = new JLabel("Name:");
    myJpanel.add(
        nameLabel,
        new CustomConstraints(0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL));
    myJpanel.add(
        nameField,
        new CustomConstraints(
            1, 0, GridBagConstraints.EAST, 1.0, 0.0, GridBagConstraints.HORIZONTAL));

    JLabel descLabel = new JLabel("Description:");
    myJpanel.add(
        descLabel,
        new CustomConstraints(0, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL));
    myJpanel.add(
        new JScrollPane(descArea),
        new CustomConstraints(1, 1, GridBagConstraints.EAST, 1.0, 0.3, GridBagConstraints.BOTH));

    JLabel pointsLabel = new JLabel("Points:");
    myJpanel.add(
        pointsLabel,
        new CustomConstraints(0, 2, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL));
    myJpanel.add(
        pointsCombo,
        new CustomConstraints(
            1, 2, GridBagConstraints.EAST, 1.0, 0.0, GridBagConstraints.HORIZONTAL));

    JButton cancelButton = new JButton("Cancel");

    cancelButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            dispose();
          }
        });

    JButton submitButton = new JButton("Submit");

    submitButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String description = descArea.getText();
            Double points = (Double) pointsCombo.getSelectedItem();

            userStory.setName(name);
            userStory.setDescription(description);
            userStory.setPointValue(points);
            dispose();
          }
        });
    JButton deleteButton = new JButton("Delete");
    deleteButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    System.out.println("delete button clicked");
                    System.out.println("User story to be deleted is :" + userStory.getId().toString());

                    List<UserStory> userStories = UserStoryStore.getInstance().getUserStories();
                    System.out.println("Before deleting");
                    for(UserStory displayUserStories : userStories){
                        System.out.println(displayUserStories.getId().toString());
                    }
                    int index =-1;
                    for(UserStory us : userStories) {
                        if(us.getId().equals(userStory.getId())) {
                            System.out.println("found the user story to be deleted");
                            index = userStories.indexOf(us);
                            break;
                        }
                    }
                    userStories.remove(index);
                    System.out.println("After deleting");
                    for(UserStory displayUserStories : userStories){
                        System.out.println(displayUserStories.getId().toString());
                    }
                    UserStoryStore.getInstance().setUserStories(userStories);
                    dispose();
                    parentWindow.closeWindow();
                }
            }
    );
    myJpanel.add(
        cancelButton,
        new CustomConstraints(0, 3, GridBagConstraints.EAST, GridBagConstraints.NONE));
    myJpanel.add(
        submitButton,
        new CustomConstraints(1, 3, GridBagConstraints.WEST, GridBagConstraints.NONE));
    myJpanel.add(
            deleteButton,
            new CustomConstraints(2, 3, GridBagConstraints.WEST, GridBagConstraints.NONE));
    add(myJpanel);
  }
}
