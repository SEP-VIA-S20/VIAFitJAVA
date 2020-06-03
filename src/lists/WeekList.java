package lists;

import javafx.scene.Scene;
import model.*;
import saves.InstructorFileAdapter;

import java.io.Serializable;
import java.util.ArrayList;

public class WeekList implements Serializable
{

  private ArrayList<Week> weeks;
  private int lastGroupID;

  public WeekList()
  {
    weeks = new ArrayList<Week>();
    lastGroupID =0;
  }
  public int size()
  {
    return weeks.size();
  }


  public ArrayList<Week> getWeeks()
  {
    return weeks;
  }

  public Week getWeek(int index)
  {
    return weeks.get(index);
  }

  public void addWeeks(Week week)
  {
    weeks.add(week);

  }
  public int getWeekIndex(ScheduledGroup group)
  {
    for(int i=0;i<weeks.size();i++)
    {
      if(weeks.get(i).containsGroup(group)) return i;
    }
    return -1;
  }
  public void addClass(ScheduledGroup group){
    int weekNumber = group.getTime().getWeekNumber();
    boolean contains = false;
    int weekIndex = -1;
    for (int i = 0; i < weeks.size(); i++)
    {
      if (weeks.get(i).getWeekNumber() == weekNumber)
      {
        contains = true;
        weekIndex = i;
      }
    }
    if(contains)
    {
      group.setGroupID(lastGroupID);
      Week temp = weeks.get(weekIndex);
      temp.addGroup(group);
      weeks.set(weekIndex,temp);
      lastGroupID++;
    }else
    {
      group.setGroupID(lastGroupID);
      Week toAdd = new Week(weekNumber);
      toAdd.addGroup(group);
      weeks.add(toAdd);
      lastGroupID++;
    }
  };
  public void removeClass(ScheduledGroup group)
  {
    for (int i = 0; i < weeks.size(); i++)
    {
        Week temp = weeks.get(i);
        temp.removeGroup(group);
        weeks.set(i,temp);
      if (isEmpty(i))
      {
        weeks.remove(i);
      }
    }
  }
  public void setGroup(int weekIndex,int dayIndex,int groupIndex,ScheduledGroup group)
  {
    Week temp = weeks.get(weekIndex);
    temp.setGroup(dayIndex,groupIndex,group);
    weeks.set(weekIndex,temp);
  }
  public void addMember(Member member, ScheduledGroup group)
  {
    int weekIndex = getWeekIndex(group);
    int dayIndex = weeks.get(weekIndex).getDayIndex(group);
    int groupIndex = weeks.get(weekIndex).getDays().get(dayIndex).getIndexOfGroup(group);
    group.addMember(member);
    setGroup(weekIndex,dayIndex,groupIndex,group);
  }
  public boolean isEmpty(int index)
  {
    if(weeks.get(index).getDays().size()==0) return true;
    return false;
  }
  public void removeWeek(Week week)
  {
    weeks.remove(week);
  }
  public void removeWeek(int index)
  {
    weeks.remove(index);
  }

  @Override public String toString()
  {
    String returned = "Weeks: ";
    for(int i=0;i<weeks.size();i++)
    {
      returned+="\n"+weeks.get(i).toString();
    }
    return returned;
  }
  public ArrayList<ScheduledGroup> getList()
  {
    if (weeks.size()==0) return null;
    ArrayList<ScheduledGroup> groupsList = new ArrayList<ScheduledGroup>();
    for (int i = 0; i < weeks.size(); i++)
    {
//      groupsList.add(new ScheduledGroup(new Group("Week nr"+weeks.get(i).getWeekNumber(),0,null),new Date(0,0,0)));
      for (int j = 0; j < weeks.get(i).getDays().size(); j++)
      {
//        groupsList.add(new ScheduledGroup(new Group("Day "+weeks.get(i).getDays().get(j).getDate(),0,new Instructor("no instructor","",0,"",0,"")),new Date(0,0,0)));
        for (int k = 0;
             k < weeks.get(i).getDays().get(j).getClasses().size(); k++)
        {
          groupsList.add(weeks.get(i).getDays().get(j).getClasses().get(k));
        }
      }
    }
    return groupsList;
  }

  public static void main(String[] args)
  {
    InstructorFileAdapter instructorFileAdapter = new InstructorFileAdapter("src/data/instructor.bin");
    Instructor inst1 = instructorFileAdapter.getAllInstructors().getInstructor(1);
    ScheduledGroup g1 = new ScheduledGroup(new Group("Jogging",20,inst1),new Date(20));
    ScheduledGroup g2 = new ScheduledGroup(new Group("Jogging",20,inst1),new Date(22));
    ScheduledGroup g3 = new ScheduledGroup(new Group("Jogging",20,inst1),new Date(24));
    ScheduledGroup g4 = new ScheduledGroup(new Group("Jogging",20,inst1),new Date(26));
    ScheduledGroup g5 = new ScheduledGroup(new Group("Jogging",20,inst1),new Date(28));
    ScheduledGroup g6 = new ScheduledGroup(new Group("Jogging",20,inst1),new Date(23));
    ScheduledGroup g7 = new ScheduledGroup(new Group("Jogging",20,inst1),new Date(30,5,2020,0,0));
    WeekList weekList = new WeekList();
    weekList.addClass(g1);
    weekList.addClass(g2);
    weekList.addClass(g3);
    weekList.addClass(g4);
    weekList.addClass(g5);
    weekList.addClass(g6);
    weekList.addClass(g7);
    System.out.println(weekList);
    System.out.println("\n\n\n");
    weekList.removeClass(g1);
    weekList.removeClass(g2);
    weekList.removeClass(g3);
    weekList.removeClass(g4);
    weekList.removeClass(g5);
    weekList.removeClass(g6);
    weekList.removeClass(g7);
    System.out.println("\n\n\n");

    System.out.println(weekList);
  }


}
