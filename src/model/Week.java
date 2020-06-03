package model;

import java.io.Serializable;
import java.time.LocalDate;
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
    Date groupDay = group.getTime();
    LocalDate tempDate = LocalDate.of(groupDay.getYear(),groupDay.getMonth(),groupDay.getDay());
    int weekDay = tempDate.getDayOfWeek().getValue();
    int dayIndex = -1;
    boolean contains = false;
    for (int i = 0; i < days.size(); i++)
    {
      if (days.get(i).getDayOfWeek()==weekDay)
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
      Day toAdd = new Day(group.getTime());
      LocalDate temp = LocalDate.of(toAdd.getDate().getYear(),toAdd.getDate().getMonth(),toAdd.getDate().getDay());
      toAdd.setDayOfWeek(temp.getDayOfWeek().getValue());
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
  public void removeGroup(ScheduledGroup group)
  {
    for (int i = 0; i < days.size(); i++)
    {
        Day temp = days.get(i);
        temp.removeGroup(group);
        days.set(i,temp);
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
      public static void main(String[] args)
    {
      ScheduledGroup test = new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(25));
      ScheduledGroup test1 = new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(26));
      ScheduledGroup test2 = new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(27));
      ScheduledGroup test3 = new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(28));
      Day day1 = new Day(test.getTime());
      Week nr1 = new Week(0);
      day1.addGroup(new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(25)));
      day1.addGroup(new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(25)));
      day1.addGroup(new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(25)));
      day1.addGroup(new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(25)));
      nr1.addGroup(test);
      nr1.addGroup(test1);
      nr1.addGroup(test2);
      nr1.addGroup(test3);
      System.out.println(nr1);
    }
}
