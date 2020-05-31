package GUI;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;

import javafx.scene.control.TabPane;

public class Controller
{
  @FXML private Label statusLabel;
  @FXML private TabPane mainTabPane;
  @FXML private TabPane membersTabPane;
  //Main Tabs
  @FXML private Tab membersTab;
  @FXML private Tab groupsTab;
  @FXML private Tab instructorsTab;
  @FXML private Tab scheduleGroupTab;
  @FXML private Tab scheduleTab;

  //Members
  @FXML private Tab searchMemberTab;
  @FXML private Tab addMemberTab;
  @FXML private Tab allMembersTab;
  @FXML private Tab editMemberTab;

  //Groups
  @FXML private Tab allGroupsTab;
  @FXML private Tab addGroupTab;
  @FXML private Tab editGroupTab;

  //Instructors
  @FXML private Tab searchInstructorTab;
  @FXML private Tab addInstructorTab;
  @FXML private Tab allInstructorsTab;
  @FXML private Tab editInstructorTab;

  //Scheduled group
  @FXML private Tab scheduleAGroupTab;
  @FXML private Tab allScheduledGroupsTab;
  @FXML private Tab addMemberToGroupTab;
  @FXML private Tab editScheduledGroupTab;

  //Schedule
  Tab tab1 = null;
  boolean once = true;

  public void handleClick(Event event)
  {
    if (event.getSource() == (allMembersTab)||event.getSource()==(editMemberTab))
    {
      editMemberTab.setDisable(false);
      setStatus("Editing");
    }
    else if(editMemberTab!=null)
    {
      editMemberTab.setDisable(true);
      setStatus("Not editable");

    }
  }
  public void setStatus(String status)
  {
    statusLabel.setText(status);
  }
}
