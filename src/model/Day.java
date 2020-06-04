package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Day implements Serializable
{
  private ArrayList<ScheduledGroup> classes;
  private Date date;
  private int dayOfWeek;

  public int getDayOfWeek()
  {
    return dayOfWeek;
  }

  public void setDayOfWeek(int dayOfWeek)
  {
    this.dayOfWeek = dayOfWeek;
  }

  public Day(Date date)
  {
    this.date = new Date(date.getDay(),date.getMonth(),date.getYear());
    classes = new ArrayList<ScheduledGroup>();
    LocalDate temp = LocalDate.of(date.getYear(),date.getMonth(),date.getDay());
    dayOfWeek =temp.getDayOfWeek().getValue();
  }

  public Day(ArrayList<ScheduledGroup> classes, Date date)
  {
    this.classes = classes;
    this.date = date;
    dayOfWeek =0;
  }
  public void addGroup(ScheduledGroup group)
  {
      classes.add(group);
  }
  public void removeGroup(int index)
  {
    classes.remove(index);
  }
  public void removeGroup(ScheduledGroup group)
  {
    classes.remove(group);
  }
  public boolean containsGroup(ScheduledGroup group)
  {
    for (int i = 0; i < classes.size(); i++)
    {
      if (classes.get(i).equals(group))
      {
        return true;
      }
    }
    return false;
  }
  public String getDayName()
  {
    int temp = date.getDayOfWeek();
    if (temp == 1)
    {
      return "monday";
    }
    else if (temp == 2)
    {
      return "tuesday";
    }
    else if (temp == 3)
    {
      return "wednesday";
    }
    else if (temp == 4)
    {
      return "thursday";
    }
    else if (temp == 5)
    {
      return "friday";
    }
    else if (temp == 6)
    {
      return "saturday";
    }
    else if (temp == 7)
    {
      return "sunday";
    }
    else return "day";
  }
  public String getXML()
  {
    return "<"+getDayName()+">\n"+toString()+"</"+getDayName()+">\n";
  }
  public boolean containsID(int id)
  {
    for (int i = 0; i < classes.size(); i++)
    {
      if (classes.get(i).getGroupID()==id)
      {
        return true;
      }
    }
    return false;
  }

  public int getIndexOfGroup(ScheduledGroup group)
  {
    for (int i = 0; i < classes.size(); i++)
    {
      if (classes.get(i).equals(group))
      {
        return i;
      }
    }
    return -1;
  }
  public int getIndexOfID(int id)
  {
    for (int i = 0; i < classes.size(); i++)
    {
      if (classes.get(i).getGroupID() == id)
      {
        return i;
      }
    }
    return -1;
  }
  public void removeById(int id)
  {
    for (int i = 0; i < classes.size(); i++)
    {
      if (classes.get(i).getGroupID()==id)
      {
        classes.remove(i);
      }
    }
  }
  public ArrayList<ScheduledGroup> getClasses()
  {
    return classes;
  }

  public void setClasses(ArrayList<ScheduledGroup> classes)
  {
    this.classes = classes;
  }
  public void setGroup(int index,ScheduledGroup group)
  {
    classes.set(index,group);
  }
  public Date getDate()
  {
    return date;
  }

  public void setDate(Date date)
  {
    this.date = date;
  }

  @Override public String toString()
  {
    String returned = ""+date.toString().replace(" 0:0","");
    for(int i=0;i<classes.size();i++)
    {
      returned+="\n"+classes.get(i).toString();
    }
    return returned;
  }

  @Override public boolean equals(Object obj)
  {
    if(!(obj instanceof Day)) return false;
    Day day = (Day)obj;
    return day.toString().equals(toString());
  }
  public boolean isEmpty()
  {
    if(classes.size()==0) return true;
    return false;
  }

  public static void main(String[] args)
  {
    ScheduledGroup test = new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(25));
    ScheduledGroup test1 = new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(28));
    ScheduledGroup test2 = new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(26));
    ScheduledGroup test3 = new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(27));
    Day day1 = new Day(test.getTime());
    day1.addGroup(test);
    day1.addGroup(test1);
    day1.addGroup(test2);
    day1.addGroup(test3);
    System.out.println(day1);
    System.out.println(day1.isEmpty());
    day1.removeGroup(test);
    day1.removeGroup(test1);
    System.out.println(day1);
    day1.removeGroup(test2);
    System.out.println(day1);
    System.out.println(day1.isEmpty());
    System.out.println(day1.getIndexOfID(1));
    System.out.println(day1.getXML());
  }
}
