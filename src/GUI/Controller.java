package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Group;
import model.Instructor;
import model.Member;
import saves.GroupFileAdaptor;
import saves.MemberFileAdapter;

import java.util.ArrayList;

public class Controller
{

  //Event listeners to add
  //search by phone
  //Add to group after search
  //Edit member
  //add member
  @FXML private Tab statusTab;
  @FXML private TabPane mainTabPane;
  @FXML private TabPane membersTabPane;
  //Main Tabs
  @FXML private Tab membersTab;
  @FXML private Tab groupsTab;
  @FXML private Tab instructorsTab;
  @FXML private Tab scheduleGroupTab;
  @FXML private Tab scheduleTab;

  //Members
//  @FXML private Tab searchMemberTab;
  //cont
  @FXML private TextField searchMemberPhoneField;
  @FXML private TableView viewMemberTable;

//  @FXML private Tab addMemberTab;
  //
  @FXML private TextField memberNameFieldAdd;
  @FXML private TextField memberAddressAdd;
  @FXML private TextField memberPhoneAdd;
  @FXML private TextField memberEmailAdd;
  @FXML private CheckBox memberPremiumAdd;

//  @FXML private Tab allMembersTab;
  //cont
  @FXML private TableView<Member> allMembersTable;
  @FXML private TableColumn<Member,String> allMembersID;
  @FXML private TableColumn<Member, String> allMembersFullName;
  @FXML private TableColumn<Member, String> allMembersAddress;
  @FXML private TableColumn<Member, Integer> allMembersPhone;
  @FXML private TableColumn<Member, String> allMembersEmail;
  @FXML private TableColumn<Member, String> allMembersMembership;


//  @FXML private Tab editMemberTab;
  //content
  @FXML private TextField memberNameFieldEdit;
  @FXML private TextField memberAddressEdit;
  @FXML private TextField memberPhoneEdit;
  @FXML private TextField memberEmailEdit;
  @FXML private CheckBox memberPremiumEdit;

  //Groups
//  @FXML private Tab allGroupsTab;
  //cont
  @FXML private TableView<Group> allGroupsTable;
  @FXML private TableColumn<Group,String> allGroupsName;
  @FXML private TableColumn<Group,String > allGroupsInstructor;
  @FXML private TableColumn<Group,String> allGroupsMaxAttendants;
  
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

  public void handleClick(Event event)
  {
  }


  public void init()
  {
    statusTab.setDisable(true);
    allMembersID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    allMembersFullName.setCellValueFactory(new PropertyValueFactory<>("name"));
    allMembersAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
    allMembersPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
    allMembersEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    allMembersMembership.setCellValueFactory(new PropertyValueFactory<>("premiumMember"));
    ArrayList<Member> tempArr = new MemberFileAdapter("src/data/members.bin").getAllMembers().getList();
    ObservableList<Member> temp = FXCollections.observableArrayList(tempArr);
    allMembersTable.setItems(temp);

    allGroupsName.setCellValueFactory(new PropertyValueFactory<>("name"));
    allGroupsInstructor.setCellValueFactory(new PropertyValueFactory<>("instructor"));
    allGroupsMaxAttendants.setCellValueFactory(new PropertyValueFactory<>("maxLimit"));
    ArrayList<Group> groupArr = new GroupFileAdaptor("src/data/groups.bin").getAllGroups().getList();
    ObservableList<Group> observableGroups = FXCollections.observableArrayList(groupArr);
    allGroupsTable.setItems(observableGroups);

  }
  public void setStatus()
  {
    statusTab.setText("Status");
  }
  public void setStatus(String status)
  {
    statusTab.setText(status);
  }
  public void setStatus(int status)
  {
    String resp ="";
    if(status ==1)
    {
      resp="Saved";
    }else if(status ==2)
    {
      resp="Modified";
    }
    else if(status ==3)
    {
      resp="Created";
    }
    else if(status ==4)
    {
      resp="Added";
    }else resp = "Status";
    statusTab.setText(resp);
  }
}
