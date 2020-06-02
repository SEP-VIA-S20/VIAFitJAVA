package lists;

import javafx.scene.Scene;
import model.*;
import saves.InstructorFileAdapter;

import java.io.Serializable;
import java.util.ArrayList;

public class WeekList implements Serializable
{

  private ArrayList<Week> weeks;

  public WeekList()
  {
    weeks = new ArrayList<Week>();
  }
  public int size()
  {
    return weeks.size();
  }

  public Week getWeek(int index)
  {
    return weeks.get(index);
  }

  public void addWeeks(Week week)
  {
    weeks.add(week);
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
      Week temp = weeks.get(weekIndex);
      temp.addGroup(group);
      weeks.set(weekIndex,temp);
    }else
    {
      Week toAdd = new Week(weekNumber);
      toAdd.addGroup(group);
      weeks.add(toAdd);
    }
  };
  public void removeClass(ScheduledGroup group)
  {
    for (int i = 0; i < weeks.size(); i++)
    {
      if (weeks.get(i).getDays().contains(group))
      {
        weeks.get(i).deleteScheduledGroup(group);
      }
      if (isEmpty())
      {
        weeks.remove(i);
      }
    }
  }

  public boolean isEmpty()
  {
    if(weeks.size()==0) return true;
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

//  public static void main(String[] args)
//  {
//    InstructorFileAdapter instructorFileAdapter = new InstructorFileAdapter("src/data/instructor.bin");
//    Instructor inst1 = instructorFileAdapter.getAllInstructors().getInstructor(1);
//    ScheduledGroup g1 = new ScheduledGroup(new Group("Jogging",20,inst1),new Date(20));
//    ScheduledGroup g2 = new ScheduledGroup(new Group("Jogging",20,inst1),new Date(22));
//    ScheduledGroup g3 = new ScheduledGroup(new Group("Jogging",20,inst1),new Date(24));
//    ScheduledGroup g4 = new ScheduledGroup(new Group("Jogging",20,inst1),new Date(26));
//    ScheduledGroup g5 = new ScheduledGroup(new Group("Jogging",20,inst1),new Date(28));
//    ScheduledGroup g6 = new ScheduledGroup(new Group("Jogging",20,inst1),new Date(23));
//    ScheduledGroup g7 = new ScheduledGroup(new Group("Jogging",20,inst1),new Date(30,5,2020,0,0));
//    WeekList weekList = new WeekList();
//    weekList.addClass(g1);
//    weekList.addClass(g2);
//    weekList.addClass(g3);
//    weekList.addClass(g4);
//    weekList.addClass(g5);
//    weekList.addClass(g6);
//    weekList.addClass(g7);
//    System.out.println(weekList);
//  }


}
