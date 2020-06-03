package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Week implements Serializable
{
  private int weekNumber;
  private ArrayList<Day> days;

  public Week(int weekNumber)
  {
    this.weekNumber = weekNumber;
    days = new ArrayList<Day>();
  }

  public int getWeekNumber()
  {
    return weekNumber;
  }
  public void setWeekNumber(int weekNumber)
  {
    this.weekNumber = weekNumber;
  }
  public void addGroup(ScheduledGroup group)
  {
    int day = group.getTime().getDay();
    int dayIndex = -1;
    boolean contains = false;
    for (int i = 0; i < days.size(); i++)
    {
      if (days.get(i).getDate().getDay() == day)
      {
        contains = true;
        dayIndex = i;
      }
    }
    if(contains)
    {
      Day temp = days.get(dayIndex);
      temp.addGroup(group);
      days.set(dayIndex,temp);
    }else
    {
      Day toAdd = new Day(day);
      toAdd.addGroup(group);
      days.add(toAdd);
    }
  }
  public void setGroup(int dayIndex,int groupIndex, ScheduledGroup group)
  {
    Day temp = days.get(dayIndex);
    temp.setGroup(groupIndex,group);
    days.set(dayIndex,temp);
  }
  public void deleteScheduledGroup(ScheduledGroup group)
  {
    for (int i = 0; i < days.size(); i++)
    {
      if (days.get(i).containsID(group.getGroupID()))
      {
        Day temp = days.get(i);
        temp.removeById(group.getGroupID());
        days.set(i, temp);
      }
      if (days.get(i).isEmpty())
      {
        days.remove(i);
      }
    }
  }
  public boolean containsGroup(ScheduledGroup group)
  {
    boolean contains = false;
    for(int i=0;i<days.size();i++)
    {
      if(days.get(i).containsGroup(group)) contains = true;
    }
    return contains;
  }
  public ArrayList<Day> getDays()
  {
    return days;
  }

  public void setDays(ArrayList<Day> days)
  {
    this.days = days;
  }
  public void addDay(Day day)
  {
    if(days.size()<7)
    {
      days.add(day);
    }
  }
  public void removeDay(Day day)
  {
    days.remove(day);
  }
  public boolean containsDay(Day day)
  {
    return days.contains(day);
  }
  public int getDayIndex(ScheduledGroup group)
  {
    for (int i = 0; i < days.size(); i++)
    {
      if (days.get(i).containsGroup(group))
      {
        return i;
      }
    }
    return -1;
  }
  @Override public String toString()
  {
    String returned = "Week nr: "+ weekNumber;
    for(int i=0;i<days.size();i++)
    {
      returned+="\n"+days.get(i).toString();
    }
    return returned;
  }

  @Override public boolean equals(Object obj)
  {
    if(!(obj instanceof Week)) return false;
    Week week = (Week)obj;
    return week.toString().equals(toString());
  }
  //    public static void main(String[] args)
//    {
//      Day day1 = new Day(25);
//      day1.addGroup(new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(25)));
//      day1.addGroup(new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(25)));
//      day1.addGroup(new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(25)));
//      day1.addGroup(new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(25)));
//      Week nr1 = new Week(20);
//      nr1.addDay(day1);
//      System.out.println(day1);
//      System.out.println(nr1);
//    }
}
