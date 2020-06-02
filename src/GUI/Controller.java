package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lists.GroupList;
import lists.InstructorList;
import lists.MemberList;
import lists.WeekList;
import model.*;
import org.w3c.dom.Text;
import saves.GroupFileAdaptor;
import saves.InstructorFileAdapter;
import saves.MemberFileAdapter;

import java.util.ArrayList;

public class Controller
{
 MemberFileAdapter members = null;
 InstructorFileAdapter instructors = null;
 GroupFileAdaptor groups = null;
 
 Member editedMember=null;
 Instructor editedInstructor=null;
 Group editedGroup = null;
 ScheduledGroup editedScheduledGroup = null;

  MemberList membersEdited;
  InstructorList instructorsEdited;
  GroupList groupsEdited;
  WeekList scheduledEdited;
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
  @FXML private Tab searchMemberTab;
  //cont
  @FXML private TextField searchMemberPhoneField;
  @FXML private TextField showMemberField;

  @FXML private Tab addMemberTab;
  //
  @FXML private TextField memberNameFieldAdd;
  @FXML private TextField memberAddressAdd;
  @FXML private TextField memberPhoneAdd;
  @FXML private TextField memberEmailAdd;
  @FXML private CheckBox memberPremiumAdd;

  @FXML private Tab allMembersTab;
  //cont
  @FXML private TableView<Member> allMembersTable;
  @FXML private TableColumn<Member,String> allMembersID;
  @FXML private TableColumn<Member, String> allMembersFullName;
  @FXML private TableColumn<Member, String> allMembersAddress;
  @FXML private TableColumn<Member, Integer> allMembersPhone;
  @FXML private TableColumn<Member, String> allMembersEmail;
  @FXML private TableColumn<Member, String> allMembersMembership;


  @FXML private Tab editMemberTab;
  //content
  @FXML private TextField memberNameFieldEdit;
  @FXML private TextField memberAddressEdit;
  @FXML private TextField memberPhoneEdit;
  @FXML private TextField memberEmailEdit;
  @FXML private CheckBox memberPremiumEdit;

  //Groups
  @FXML private Tab allGroupsTab;
  //cont
  @FXML private TableView<Group> allGroupsTable;
  @FXML private TableColumn<Group,String> allGroupsName;
  @FXML private TableColumn<Group,String > allGroupsInstructor;
  @FXML private TableColumn<Group,String> allGroupsMaxAttendants;
  
  @FXML private Tab addGroupTab;
  //cont
  @FXML private TextField groupNameAdd;
  @FXML private TextField maxAttendantsAdd;
  @FXML private ComboBox allInstructorsAddGroup;

  @FXML private Tab editGroupTab;
  //cont
  @FXML private TextField groupNameEdit;
  @FXML private TextField maxAttendantsEdit;
  @FXML private ComboBox allInstructorsEditGroup;

  //Instructors
    @FXML private Tab addInstructorTab;

  @FXML private TextField searchInstructorPhoneField;
  @FXML private TextField showInstructorField;
  //
  @FXML private TextField instructorNameFieldAdd;
  @FXML private TextField instructorAddressAdd;
  @FXML private TextField instructorPhoneAdd;
  @FXML private TextField instructorEmailAdd;
  @FXML private TextArea instructorDescriptionAdd;

    @FXML private Tab allInstructorsTab;
  //cont
  @FXML private TableView<Instructor> allInstructorsTable;
  @FXML private TableColumn<Instructor,String> allInstructorsID;
  @FXML private TableColumn<Instructor, String> allInstructorsFullName;
  @FXML private TableColumn<Instructor, String> allInstructorsAddress;
  @FXML private TableColumn<Instructor, Integer> allInstructorsPhone;
  @FXML private TableColumn<Instructor, String> allInstructorsEmail;
  @FXML private TableColumn<Instructor, String> allInstructorsDescription;


    @FXML private Tab editInstructorTab;
  //content
  @FXML private TextField instructorNameFieldEdit;
  @FXML private TextField instructorAddressEdit;
  @FXML private TextField instructorPhoneEdit;
  @FXML private TextField instructorEmailEdit;
  @FXML private TextArea instructorDescriptionEdit;

  //Scheduled group
  @FXML private Tab scheduleAGroupTab;

  @FXML private TextField scheduleGroupName;
  @FXML private TextField scheduleGroupMaxAttendants;
  @FXML private TextField scheduleGroupHour;
  @FXML private TextField scheduleGroupMinutes;
  @FXML private ComboBox scheduleGroupInstructorsCombo;
  @FXML private DatePicker scheduleGroupDatePicker;

  @FXML private Tab allScheduledGroupsTab;

  @FXML private TableView<ScheduledGroup> allScheduledGroupsTable;
  @FXML private TableColumn<ScheduledGroup,String> allScheduledGroupsName;
  @FXML private TableColumn<ScheduledGroup,String > allScheduledGroupsInstructor;
  @FXML private TableColumn<ScheduledGroup,String> allScheduledGroupsMaxAttendants;
  @FXML private TableColumn<ScheduledGroup,String> allScheduledGroupsDate;
  @FXML private TableColumn<ScheduledGroup,String> allScheduledGroupsMembers;

  @FXML private Tab addMemberToGroupTab;

  @FXML private TableView<Member> addMemberMemberTable;
  @FXML private TableColumn<Member,String> addMemberMemberName;
  @FXML private TableColumn<Member,String > addMemberMemberPhone;

  @FXML private TableView<ScheduledGroup> addMemberGroupTable;
  @FXML private TableColumn<ScheduledGroup,String> addMemberGroupName;
  @FXML private TableColumn<ScheduledGroup,String > addMemberSpaceLeft;

  @FXML private Tab editScheduledGroupTab;

  @FXML private TextField editScheduledGroupName;
  @FXML private TextField editScheduledGroupMaxAttendants;
  @FXML private TextField editScheduledGroupHour;
  @FXML private TextField editScheduledGroupMinutes;
  @FXML private ComboBox editScheduledGroupInstructorsCombo;
  @FXML private DatePicker editScheduledGroupDatePicker;

  @FXML private TableView<Week> scheduledTable;
  @FXML private TableColumn<Week,String> weekNrTableTab;
  @FXML private TableColumn<Week,String > MondayTableTab;
  @FXML private TableColumn<Week,String > TuesdayTableTab;
  @FXML private TableColumn<Week,String > WednesdayTableTab;
  @FXML private TableColumn<Week,String > ThursdayTableTab;
  @FXML private TableColumn<Week,String > FridayTableTab;
  @FXML private TableColumn<Week,String > SaturdayTableTab;

  public void init()
  {
    members = new MemberFileAdapter("src/data/members.bin");
    groups = new GroupFileAdaptor("src/data/groups.bin");
    instructors = new InstructorFileAdapter("src/data/instructor.bin");

    statusTab.setDisable(true);
    showMemberField.setEditable(false);
    showInstructorField.setEditable(false);
    disableEditTabs();
    ObservableList<String> instructorDropBox = FXCollections.observableArrayList(instructors.getAllInstructors().getInstructorsArray());
    allInstructorsAddGroup.setItems(instructorDropBox);
    updateAllMembersTable();
    updateAllGroupsTable();
    updateAllInstructorsTable();


  }
  public void disableEditTabs()
  {
    editMemberTab.setDisable(true);
    editGroupTab.setDisable(true);
    editInstructorTab.setDisable(true);
    editScheduledGroupTab.setDisable(true);
  }
  public void enableEditTabs()
  {
    editMemberTab.setDisable(false);
    editGroupTab.setDisable(false);
    editInstructorTab.setDisable(false);
    editScheduledGroupTab.setDisable(false);
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

  public void addToGroupSearched(ActionEvent actionEvent)
  {
  }

  public void searchMember(ActionEvent actionEvent)
  {
    membersEdited = members.getAllMembers();
    int phone = Integer.parseInt(searchMemberPhoneField.getText().trim());
    editedMember = membersEdited.getMemberByPhone(phone);
    showMemberField.setText(editedMember.getName()+" "+editedMember.getPhone());
  }

  public void editMemberTable(ActionEvent actionEvent)
  {
    editedMember =allMembersTable.getSelectionModel().getSelectedItem();
    memberNameFieldEdit.setText(editedMember.getName());
    memberAddressEdit.setText(editedMember.getAddress());
    memberPhoneEdit.setText(editedMember.getPhone()+"");
    memberEmailEdit.setText(editedMember.getEmail());
    memberPremiumEdit.setSelected(editedMember.isPremiumMember());
    
    membersTabPane.getSelectionModel().select(editMemberTab);
    enableEditTabs();
  }
  public void editMemberSearch(ActionEvent actionEvent)
  {
    editedMember = membersEdited.getMemberByPhone(Integer.parseInt(searchMemberPhoneField.getText().trim()));
    memberNameFieldEdit.setText(editedMember.getName());
    memberAddressEdit.setText(editedMember.getAddress());
    memberPhoneEdit.setText(editedMember.getPhone()+"");
    memberEmailEdit.setText(editedMember.getEmail());
    memberPremiumEdit.setSelected(editedMember.isPremiumMember());

    membersTabPane.getSelectionModel().select(editMemberTab);
    enableEditTabs();
  }

  public void saveEditedMember(ActionEvent actionEvent)
  {
    membersEdited = members.getAllMembers();
    Member toAdd = new Member(memberNameFieldEdit.getText(),memberAddressEdit.getText(),Integer.parseInt(memberPhoneEdit.getText()),memberEmailEdit.getText(),editedMember.getID(),memberPremiumEdit.isSelected());
    membersEdited.setMember(membersEdited.indexOfPhoneNumber(editedMember.getPhone()),toAdd);
    members.saveMembers(membersEdited);
    setStatus(2);
    updateAllMembersTable();
    disableEditTabs();
  }

  public void addMember(ActionEvent actionEvent)
  {

    String name = memberNameFieldAdd.getText();
    String address = memberAddressAdd.getText();
    int phone = Integer.parseInt(memberPhoneAdd.getText());
    String email = memberEmailAdd.getText();
    boolean membership = memberPremiumAdd.isSelected();
    Member created = new Member(name,address,phone,email,0,membership);
    members.addMember(created);
    setStatus(3);
    updateAllMembersTable();
  }

  public void deleteMember(ActionEvent actionEvent)
  {
  }

  public void deleteGroup(ActionEvent actionEvent)
  {
  }

  public void editGroup(ActionEvent actionEvent)
  {
  }

  public void addGroup(ActionEvent actionEvent)
  {
  }

  public void saveEditedGroup(ActionEvent actionEvent)
  {
  }

  public void searchInstructor(ActionEvent actionEvent)
  {
    instructorsEdited = instructors.getAllInstructors();
    int phone = Integer.parseInt(searchInstructorPhoneField.getText().trim());
    editedInstructor = instructorsEdited.getInstructorByPhone(phone);
    showInstructorField.setText(editedInstructor.getName()+" "+editedInstructor.getPhone());
  }

  public void editInstructorTable(ActionEvent actionEvent)
  {
    editedInstructor = instructorsEdited.getInstructorByPhone(Integer.parseInt(searchInstructorPhoneField.getText().trim()));
    instructorNameFieldEdit.setText(editedInstructor.getName());
    instructorAddressEdit.setText(editedInstructor.getAddress());
    instructorPhoneEdit.setText(editedInstructor.getPhone()+"");
    instructorEmailEdit.setText(editedInstructor.getEmail());
    instructorDescriptionEdit.setText(editedInstructor.getDescription());

    membersTabPane.getSelectionModel().select(editMemberTab);
    enableEditTabs();

  }

  public void editInstructorSearch(ActionEvent actionEvent)
  {
    editedInstructor = instructorsEdited.getInstructorByPhone(Integer.parseInt(searchInstructorPhoneField.getText().trim()));
    instructorNameFieldEdit.setText(editedInstructor.getName());
    instructorAddressEdit.setText(editedInstructor.getAddress());
    instructorPhoneEdit.setText(editedInstructor.getPhone()+"");
    instructorEmailEdit.setText(editedInstructor.getEmail());
    instructorDescriptionEdit.setText(editedInstructor.getDescription());

//    instructorsTab.getSelectionModel().select(editInstructorTab);
//    enableEditTabs();

  }
  public void addInstructor(ActionEvent actionEvent)
  {
    String name = instructorNameFieldAdd.getText();
    String address = instructorAddressAdd.getText();
    int phone = Integer.parseInt(instructorPhoneAdd.getText());
    String email = instructorEmailAdd.getText();
    String description = instructorDescriptionAdd.getText();
    Instructor created = new Instructor(name,address,phone,email,0,description);
    instructors.addInstructor(created);
    setStatus(3);
    updateAllInstructorsTable();
  }

  public void deleteInstructor(ActionEvent actionEvent)
  {
  }

  public void saveEditedInstructor(ActionEvent actionEvent)
  {
  }

  public void scheduleClass(ActionEvent actionEvent)
  {
  }

  public void deleteScheduledGroup(ActionEvent actionEvent)
  {
  }

  public void editScheduledGroup(ActionEvent actionEvent)
  {
  }

  public void addMemberToGroupTable(ActionEvent actionEvent)
  {
  }

  public void saveEditedScheduledGroup(ActionEvent actionEvent)
  {
  }
  public void updateAllMembersTable()
  {
    allMembersID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    allMembersFullName.setCellValueFactory(new PropertyValueFactory<>("name"));
    allMembersAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
    allMembersPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
    allMembersEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    allMembersMembership.setCellValueFactory(new PropertyValueFactory<>("premiumMember"));
    ArrayList<Member> tempArr = members.getAllMembers().getList();
    ObservableList<Member> temp = FXCollections.observableArrayList(tempArr);
    allMembersTable.setItems(temp);
  }
  public void updateAllGroupsTable()
  {
    allGroupsName.setCellValueFactory(new PropertyValueFactory<>("name"));
    allGroupsInstructor.setCellValueFactory(new PropertyValueFactory<>("instructor"));
    allGroupsMaxAttendants.setCellValueFactory(new PropertyValueFactory<>("maxLimit"));
    ArrayList<Group> groupArr = groups.getAllGroups().getList();
    ObservableList<Group> observableGroups = FXCollections.observableArrayList(groupArr);
    allGroupsTable.setItems(observableGroups);
  }

  public void updateAllInstructorsTable()
  {
    allInstructorsFullName.setCellValueFactory(new PropertyValueFactory<>("name"));
    allInstructorsAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
    allInstructorsPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
    allInstructorsEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    allInstructorsID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    allInstructorsDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
    ArrayList<Instructor> tempArr = instructors.getAllInstructors().getList();
    ObservableList<Instructor> temp = FXCollections.observableArrayList(tempArr);
    allInstructorsTable.setItems(temp);
  }
}
