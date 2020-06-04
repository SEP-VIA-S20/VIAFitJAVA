package GUI;

import javafx.beans.Observable;
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
import saves.*;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Controller
{
 MemberFileAdapter members = null;
 InstructorFileAdapter instructors = null;
 GroupFileAdaptor groups = null;
 WeekFileAdapter weeks = null;
 
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
  @FXML private TabPane instructorsTabPane;
  @FXML private TabPane groupTabPane;
  @FXML private TabPane scheduledGroupTabPane;

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

  @FXML private ComboBox allGroupsScheduleCombo;
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
  @FXML private TableColumn<Week,String > SundayTableTab;

  public void init()
  {
    members = new MemberFileAdapter("src/data/members.bin");
    groups = new GroupFileAdaptor("src/data/groups.bin");
    instructors = new InstructorFileAdapter("src/data/instructor.bin");
    weeks = new WeekFileAdapter("src/data/scheduled.bin");

    statusTab.setDisable(true);
    showMemberField.setEditable(false);
    showInstructorField.setEditable(false);
    editScheduledGroupDatePicker.setDisable(true);

    disableEditTabs();

    if(members.getAllMembers()!=null)
    {
      updateAllMembersTable();
      updateAddMemberMemberTable();
    }
    if(groups.getAllGroups()!=null)
    {
      updateAllGroupsTable();
      updateAllGroupsCombo();
    }
    if(instructors.getAllInstructors()!=null)
    {
      updateAllInstructorsTable();
      updateGroupInstructors();
    }
    if(weeks.getAllWeeks()!=null)
    {
      updateScheduledGroupsTables();
      updateSchedule();
    }

    allInstructorsAddGroup.getSelectionModel().select("Select Instructor");


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
      resp="Deleted";
    }else resp = "Status";
    statusTab.setText(resp);
  }

  public void addToGroupSearched(ActionEvent actionEvent)
  {
    mainTabPane.getSelectionModel().select(scheduleAGroupTab);
    scheduledGroupTabPane.getSelectionModel().select(addMemberToGroupTab);
    addMemberMemberTable.getSelectionModel().select(editedMember);
  }

  public void searchMember(ActionEvent actionEvent)
  {
    membersEdited = members.getAllMembers();
    int phone = Integer.parseInt(searchMemberPhoneField.getText().trim());
    editedMember = membersEdited.getMemberByPhone(phone);
    if(editedMember!=null)
    {
      showMemberField.setText(editedMember.getName()+" "+editedMember.getPhone());
    }
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
    cleanAddMember();
    membersTabPane.getSelectionModel().select(allMembersTab);
    updateAllMembersTable();
    updateAddMemberMemberTable();

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
    updateAddMemberMemberTable();
    allMembersTable.refresh();
    membersTabPane.getSelectionModel().select(allMembersTab);
  }

  public void deleteMember(ActionEvent actionEvent)
  {
    Alert alert = new Alert(
        Alert.AlertType.CONFIRMATION, "Delete " + allMembersTable.getSelectionModel().getSelectedItem().getName() + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
    alert.showAndWait();

    if (alert.getResult() == ButtonType.YES) {
      //do stuff
      members.deleteMembers(allMembersTable.getSelectionModel().getSelectedItem());
      setStatus(4);
      updateAllMembersTable();
      updateAddMemberMemberTable();
    }
  }

  public void deleteGroup(ActionEvent actionEvent)
  {
    groups.deleteGroup(allGroupsTable.getSelectionModel().getSelectedItem());
    setStatus(4);
    updateAllGroupsTable();
    updateAllGroupsCombo();
  }

  public void editGroup(ActionEvent actionEvent)
  {
    editedGroup = allGroupsTable.getSelectionModel().getSelectedItem();
    groupNameEdit.setText(editedGroup.getName());
    allInstructorsEditGroup.getSelectionModel().select(instructors.getAllInstructors().getIndex(editedGroup.getInstructor()));
    maxAttendantsEdit.setText(editedGroup.getMaxLimit()+"");
    groupTabPane.getSelectionModel().select(editGroupTab);
    enableEditTabs();
  }

  public void addGroup(ActionEvent actionEvent)
  {
    instructorsEdited = instructors.getAllInstructors();
    Group groupToAdd = new Group(groupNameAdd.getText(),Integer.parseInt(maxAttendantsAdd.getText()),instructorsEdited.getInstructorByName((String)allInstructorsAddGroup.getSelectionModel().getSelectedItem()));
    groups.addGroup(groupToAdd);
    setStatus(3);
    updateAllGroupsTable();
    groupTabPane.getSelectionModel().select(allGroupsTab);
    cleanGroupAdd();
    updateAllGroupsCombo();
  }

  public void saveEditedGroup(ActionEvent actionEvent)
  {
    String groupName = editedGroup.getName();
    Group groupToEdit = new Group(groupNameEdit.getText(),Integer.parseInt(maxAttendantsEdit.getText().trim()),instructors.getAllInstructors().getInstructorByName((String)allInstructorsEditGroup.getSelectionModel().getSelectedItem()));
    groupsEdited = groups.getAllGroups();
    groupsEdited.setGroup(groups.getAllGroups().getIndexOfName(groupName),groupToEdit);
    groups.saveGroup(groupsEdited);
    disableEditTabs();
    updateAllGroupsTable();
    setStatus(2);
    groupTabPane.getSelectionModel().select(allGroupsTab);
    updateAllGroupsTable();
    updateAllGroupsCombo();
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
    editedInstructor = allInstructorsTable.getSelectionModel().getSelectedItem();
    instructorNameFieldEdit.setText(editedInstructor.getName());
    instructorAddressEdit.setText(editedInstructor.getAddress());
    instructorPhoneEdit.setText(editedInstructor.getPhone()+"");
    instructorEmailEdit.setText(editedInstructor.getEmail());
    instructorDescriptionEdit.setText(editedInstructor.getDescription());

    instructorsTabPane.getSelectionModel().select(editInstructorTab);
    enableEditTabs();
    updateGroupInstructors();
    allInstructorsTable.refresh();

  }

  public void editInstructorSearch(ActionEvent actionEvent)
  {
    editedInstructor = instructorsEdited.getInstructorByPhone(Integer.parseInt(searchInstructorPhoneField.getText().trim()));
    instructorNameFieldEdit.setText(editedInstructor.getName());
    instructorAddressEdit.setText(editedInstructor.getAddress());
    instructorPhoneEdit.setText(editedInstructor.getPhone()+"");
    instructorEmailEdit.setText(editedInstructor.getEmail());
    instructorDescriptionEdit.setText(editedInstructor.getDescription());

    instructorsTabPane.getSelectionModel().select(editInstructorTab);
    enableEditTabs();
    updateGroupInstructors();

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
    cleanInstructorsAdd();
    instructorsTabPane.getSelectionModel().select(allInstructorsTab);
    updateGroupInstructors();
  }

  public void deleteInstructor(ActionEvent actionEvent)
  {
    instructors.deleteInstructor(allInstructorsTable.getSelectionModel().getSelectedItem());
    setStatus(4);
    updateAllInstructorsTable();
    updateGroupInstructors();
  }

  public void saveEditedInstructor(ActionEvent actionEvent)
  {
    instructorsEdited = instructors.getAllInstructors();
    Instructor toAdd = new Instructor(instructorNameFieldEdit.getText(),instructorAddressEdit.getText(),Integer.parseInt(instructorPhoneEdit.getText()),instructorEmailEdit.getText(),editedInstructor.getID(),instructorDescriptionEdit.getText());
    instructorsEdited.setInstructor(instructorsEdited.indexOfPhoneNumber(editedInstructor.getPhone()),toAdd);
    instructors.saveInstructors(instructorsEdited);
    setStatus(2);
    updateAllInstructorsTable();
    disableEditTabs();
    instructorsTabPane.getSelectionModel().select(allInstructorsTab);
  }

  public void updateScheduleGroupFields(ActionEvent event)
  {
    if (groups.getAllGroups().getIndexOfName((String) allGroupsScheduleCombo.getSelectionModel().getSelectedItem())!=-1)
    {
      Group temp = groups.getAllGroups().getGroup(groups.getAllGroups().getIndexOfName((String) allGroupsScheduleCombo.getSelectionModel().getSelectedItem()));
      scheduleGroupName.setText(temp.getName());
      scheduleGroupMaxAttendants.setText(temp.getMaxLimit()+"");
      scheduleGroupInstructorsCombo.getSelectionModel().select(instructors.getAllInstructors().getIndex(temp.getInstructor()));
    }
    }

  public void scheduleClass(ActionEvent actionEvent)
  {
    Group toAdd = new Group(scheduleGroupName.getText(),Integer.parseInt(scheduleGroupMaxAttendants.getText().trim()),instructors.getAllInstructors().getInstructorByName((String) scheduleGroupInstructorsCombo.getSelectionModel().getSelectedItem()));
    LocalDate localDate = scheduleGroupDatePicker.getValue();
    Date groupDate = new Date(localDate.getDayOfMonth(),localDate.getMonthValue(),localDate.getYear(),new Time(Integer.parseInt(scheduleGroupHour.getText().trim()),Integer.parseInt(scheduleGroupMinutes.getText().trim())));
    ScheduledGroup groupToAdd = new ScheduledGroup(toAdd,groupDate);

    if(groups.getAllGroups()!=null)
    {
      groupsEdited = groups.getAllGroups();
      if((groupsEdited.getIndexOfName(toAdd.getName())==-1))
      {
        groupsEdited.addGroup(toAdd);
        groups.saveGroup(groupsEdited);
      }
    }
    weeks.addScheduledGroup(groupToAdd);
    scheduledGroupTabPane.getSelectionModel().select(allScheduledGroupsTab);
    updateScheduledGroupsTables();
    updateSchedule();
    refreshScheduled();
    updateAddMemberMemberTable();
    updateScheduledGroupsTables();
    updateSchedule();
    refreshScheduled();
  }

  public void deleteScheduledGroup(ActionEvent actionEvent)
  {
    weeks.deleteScheduledGroup(allScheduledGroupsTable.getSelectionModel().getSelectedItem());
    updateScheduledGroupsTables();
    updateSchedule();
    refreshScheduled();
  }

  public void editScheduledGroup(ActionEvent actionEvent)
  {
    scheduledGroupTabPane.getSelectionModel().select(editScheduledGroupTab);
    enableEditTabs();
    if(allScheduledGroupsTable.getSelectionModel().getSelectedItem()!=null)
    {
      editedScheduledGroup = allScheduledGroupsTable.getSelectionModel().getSelectedItem();
      editScheduledGroupName.setText(editedScheduledGroup.getName());
      editScheduledGroupHour.setText(editedScheduledGroup.getTime().getTime().getHour()+"");
      editScheduledGroupMinutes.setText(editedScheduledGroup.getTime().getTime().getMinute()+"");
      editScheduledGroupMaxAttendants.setText(editedScheduledGroup.getMaxLimit()+"");
      editScheduledGroupInstructorsCombo.getSelectionModel().select(instructors.getAllInstructors().getIndex(editedScheduledGroup.getInstructor()));
      LocalDate tempDate = LocalDate.of(editedScheduledGroup.getTime().getYear(),editedScheduledGroup.getTime().getMonth(),editedScheduledGroup.getTime().getDay());
      editScheduledGroupDatePicker.setValue(tempDate);
    }
  }
  public void addMemberToGroupTable(ActionEvent actionEvent)
  {
    Member tempMember = addMemberMemberTable.getSelectionModel().getSelectedItem();
    ScheduledGroup tempGroup = addMemberGroupTable.getSelectionModel().getSelectedItem();
    scheduledEdited = weeks.getAllWeeks();
    scheduledEdited.addMember(tempMember,tempGroup);
    weeks.saveWeeks(scheduledEdited);
    updateScheduledGroupsTables();
    updateAddMemberMemberTable();
    updateSchedule();
    refreshScheduled();
  }
  public void saveEditedScheduledGroup(ActionEvent actionEvent)
  {
    editedScheduledGroup = allScheduledGroupsTable.getSelectionModel().getSelectedItem();
    int weekIndex = weeks.getAllWeeks().getWeekIndex(editedScheduledGroup);
    int dayIndex = weeks.getAllWeeks().getWeek(weekIndex).getDayIndex(editedScheduledGroup);
    int groupIndex = weeks.getAllWeeks().getWeek(weekIndex).getDays().get(dayIndex).getIndexOfGroup(editedScheduledGroup);
    
    Group tempGroup = new Group(editScheduledGroupName.getText(),(Integer.parseInt(editScheduledGroupMaxAttendants.getText().trim())),instructors.getAllInstructors().getInstructorByName((String) editScheduledGroupInstructorsCombo.getSelectionModel().getSelectedItem()));
    LocalDate temp = editScheduledGroupDatePicker.getValue();
    int minutes = Integer.parseInt(editScheduledGroupMinutes.getText().trim());
    int hours = Integer.parseInt(editScheduledGroupHour.getText().trim());
    Date tempDate = new Date(temp.getDayOfMonth(),temp.getMonthValue(),temp.getYear(),hours,minutes);

    ScheduledGroup toReplace = new ScheduledGroup(tempGroup,tempDate);
    toReplace.setSpaceLeft(editedScheduledGroup.getSpaceLeft()+(Integer.parseInt(editScheduledGroupMaxAttendants.getText().trim())-editedScheduledGroup.getMaxLimit()));
    toReplace.addMembers(editedScheduledGroup.getMembers());
    scheduledEdited = weeks.getAllWeeks();
    scheduledEdited.setGroup(weekIndex,groupIndex,toReplace);
    scheduledGroupTabPane.getSelectionModel().select(allScheduledGroupsTab);
    weeks.saveWeeks(scheduledEdited);
    disableEditTabs();
    updateAddMemberMemberTable();
    updateScheduledGroupsTables();
    updateSchedule();
    refreshScheduled();
  }
  public void bookGroup(ActionEvent event)
  {
    updateScheduledGroupsTables();
    updateSchedule();
    refreshScheduled();

  }
  public void exportXML()
  {
    TextFileIO xmlout = new TextFileIO();
    try
    {
      xmlout.writeToFile("src/data/SCHEDULE.xml",weeks.getAllWeeks().getXML());
    }catch (FileNotFoundException e)
    {
      System.out.println("no file");
    }
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
    if(groups.getAllGroups().getList()!=null)
    {
      allGroupsName.setCellValueFactory(new PropertyValueFactory<>("name"));
      allGroupsInstructor.setCellValueFactory(new PropertyValueFactory<>("instructor"));
      allGroupsMaxAttendants.setCellValueFactory(new PropertyValueFactory<>("maxLimit"));
      ArrayList<Group> groupArr = groups.getAllGroups().getList();
      ObservableList<Group> observableGroups = FXCollections.observableArrayList(groupArr);
      allGroupsTable.setItems(observableGroups);
    }

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
  public void updateGroupInstructors()
  {
      ObservableList<String> instructorDropBox = FXCollections.observableArrayList(instructors.getAllInstructors().getInstructorsArray());
      allInstructorsEditGroup.setItems(instructorDropBox);
      allInstructorsAddGroup.setItems(instructorDropBox);
      scheduleGroupInstructorsCombo.setItems(instructorDropBox);
      editScheduledGroupInstructorsCombo.setItems(instructorDropBox);

  }
  public void updateAllGroupsCombo()
  {
    if (groups.getAllGroups().getStringArray() != null)
    {
      ObservableList<String> groupsCombo = FXCollections
          .observableArrayList(groups.getAllGroups().getStringArray());
      allGroupsScheduleCombo.setItems(groupsCombo);
    }

  }
  public void cleanAddMember()
  {
    memberNameFieldAdd.setText("");
    memberPhoneAdd.setText("");
    memberEmailAdd.setText("");
    memberAddressAdd.setText("");
    memberPremiumAdd.setSelected(false);
  }
  public void cleanInstructorsAdd()
  {
    instructorNameFieldAdd.setText("");
    instructorPhoneAdd.setText("");
    instructorEmailAdd.setText("");
    instructorAddressAdd.setText("");
    instructorDescriptionAdd.setText("");
  }
  public void cleanGroupAdd()
  {
    groupNameAdd.setText("");
    allInstructorsAddGroup.getSelectionModel().select("Select Instructor");
    maxAttendantsAdd.setText("");
  }
  public void updateScheduledGroupsTables()
  {
      if(weeks.getAllWeeks()!=null)
      {
        addMemberGroupName.setCellValueFactory(new PropertyValueFactory<>("name"));
        addMemberSpaceLeft.setCellValueFactory(new PropertyValueFactory<>("spaceLeft"));
        allScheduledGroupsName.setCellValueFactory(new PropertyValueFactory<>("name"));
        allScheduledGroupsInstructor.setCellValueFactory(new PropertyValueFactory<>("instructor"));
        allScheduledGroupsMaxAttendants.setCellValueFactory(new PropertyValueFactory<>("maxLimit"));
        allScheduledGroupsDate.setCellValueFactory(new PropertyValueFactory<>("time"));
        allScheduledGroupsMembers.setCellValueFactory(new PropertyValueFactory<>("members"));
        ArrayList<ScheduledGroup> tempArr = weeks.getAllWeeks().getList();
        ObservableList<ScheduledGroup> temp = FXCollections.observableArrayList(tempArr);
        allScheduledGroupsTable.setItems(temp);
        addMemberGroupTable.setItems(temp);
      }
  }
  public void updateAddMemberMemberTable()
  {
      addMemberMemberName.setCellValueFactory(new PropertyValueFactory<>("name"));
      addMemberMemberPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
      ArrayList<Member> tempMembers = members.getAllMembers().getList();
      ObservableList<Member> newObsMembers = FXCollections.observableArrayList(tempMembers);
      addMemberMemberTable.setItems(newObsMembers);
  }
  public void updateSchedule()
  {
    if(weeks.getAllWeeks().getWeeks()!=null)
    {
      weekNrTableTab.setCellValueFactory(new PropertyValueFactory<>("weekNumber"));
      MondayTableTab.setCellValueFactory(new PropertyValueFactory<>("monday"));
      TuesdayTableTab.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
      WednesdayTableTab.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
      ThursdayTableTab.setCellValueFactory(new PropertyValueFactory<>("thursday"));
      FridayTableTab.setCellValueFactory(new PropertyValueFactory<>("friday"));
      SaturdayTableTab.setCellValueFactory(new PropertyValueFactory<>("saturday"));
      SundayTableTab.setCellValueFactory(new PropertyValueFactory<>("sunday"));
      ArrayList<Week> tempWeek = weeks.getAllWeeks().getWeeks();
      ObservableList<Week> newObsWeeks = FXCollections.observableArrayList(tempWeek);
      scheduledTable.setItems(newObsWeeks);
    }else
    {
      scheduledTable.getItems().clear();
    }


  }
  public void refreshScheduled()
  {
    scheduledTable.refresh();
    allScheduledGroupsTable.refresh();
    addMemberGroupTable.refresh();
  }

}
