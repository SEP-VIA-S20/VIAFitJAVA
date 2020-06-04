package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Week implements Serializable
{
  private int weekNumber;
  private ArrayList<Day> days;
  private Day sunday;
  private Day monday;
  private Day tuesday;
  private Day wednesday;
  private Day friday;
  private Day saturday;
  private Day thursday;

  public Week(int weekNumber)
  {
    this.weekNumber = weekNumber;
    days = new ArrayList<Day>();
//    sunday.setDayOfWeek(7);
//    monday.setDayOfWeek(7);
//    tuesday.setDayOfWeek(7);
//    wednesday.setDayOfWeek(7);
//    thursday.setDayOfWeek(7);
//    friday.setDayOfWeek(7);
//    saturday.setDayOfWeek(7);
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
    if(group.getTime().getWeekNumber() ==weekNumber)
    {
      for (int i = 0; i < days.size(); i++)
      {
        if (days.get(i).getDayOfWeek()==weekDay)
        {
          contains = true;
          dayIndex = i;
        }
      }
    }
    if(contains)
    {
      int temp = days.get(dayIndex).getDayOfWeek();
      if(temp==1)
      {
        monday.addGroup(group);
      }
      else if(temp==2)
      {
        tuesday.addGroup(group);
      }
      else if(temp==3)
      {
        wednesday.addGroup(group);
      }
      else if(temp==4)
      {
        thursday.addGroup(group);
      }
      else if(temp==5)
      {
        friday.addGroup(group);
      }
      else if(temp==6)
      {
        saturday.addGroup(group);
      }
      else if(temp==7)
      {
        sunday.addGroup(group);
      }
    }else if(group.getTime().getWeekNumber() ==weekNumber)
    {
      int temp = LocalDate.of(group.getTime().getYear(),group.getTime().getMonth(),group.getTime().getDay()).getDayOfWeek().getValue();
      if(temp==1)
      {
        monday = new Day(group.getTime());
        monday.setDayOfWeek(1);
        monday.addGroup(group);
        days.add(monday);
      }
      else if (temp ==2)
      {
        tuesday = new Day(group.getTime());
        tuesday.setDayOfWeek(2);
        tuesday.addGroup(group);
        days.add(tuesday);
      }
      else if (temp ==3)
      {
        wednesday = new Day(group.getTime());
        wednesday.setDayOfWeek(3);
        wednesday.addGroup(group);
        days.add(wednesday);
      }
      else if (temp ==4)
      {
        thursday = new Day(group.getTime());
        thursday.setDayOfWeek(4);
        thursday.addGroup(group);
        days.add(thursday);
      }
      else if (temp ==5)
      {
        friday = new Day(group.getTime());
        friday.setDayOfWeek(5);
        friday.addGroup(group);
        days.add(friday);
      }
      else if (temp ==6)
      {
        saturday = new Day(group.getTime());
        saturday.setDayOfWeek(6);
        saturday.addGroup(group);
        days.add(saturday);
      }
      else if (temp ==7)
      {
        sunday = new Day(group.getTime());
        sunday.setDayOfWeek(7);
        sunday.addGroup(group);
        days.add(sunday);
      }

    }
  }

  public Day getSunday()
  {
    return sunday;
  }

  public void setSunday(Day sunday)
  {
    this.sunday = sunday;
  }

  public Day getMonday()
  {
    return monday;
  }

  public void setMonday(Day monday)
  {
    this.monday = monday;
  }

  public Day getTuesday()
  {
    return tuesday;
  }

  public void setTuesday(Day tuesday)
  {
    this.tuesday = tuesday;
  }

  public Day getWednesday()
  {
    return wednesday;
  }

  public void setWednesday(Day wednesday)
  {
    this.wednesday = wednesday;
  }

  public Day getFriday()
  {
    return friday;
  }

  public void setFriday(Day friday)
  {
    this.friday = friday;
  }

  public Day getSaturday()
  {
    return saturday;
  }

  public void setSaturday(Day saturday)
  {
    this.saturday = saturday;
  }

  public Day getThursday()
  {
    return thursday;
  }

  public void setThursday(Day thursday)
  {
    this.thursday = thursday;
  }

  public void setGroup(int groupIndex, ScheduledGroup group)
  {
    int temp = group.getTime().getDayOfWeek();
    if(temp==1)
    {
      monday.setGroup(groupIndex,group);
    }
    else if(temp==2)
    {
      tuesday.setGroup(groupIndex,group);
    }
    else if(temp==3)
    {
      wednesday.setGroup(groupIndex,group);
    }
    else if(temp==4)
    {
      thursday.setGroup(groupIndex,group);
    }
    else if(temp==5)
    {
      friday.setGroup(groupIndex,group);
    }
    else if(temp==6)
    {
      saturday.setGroup(groupIndex,group);
    }
    else if(temp==7)
    {
      sunday.setGroup(groupIndex,group);
    }
  }
  public void removeGroup(ScheduledGroup group)
  {
    for (int i = 0; i < days.size(); i++)
    {
      int temp = group.getTime().getDayOfWeek();
      if (temp == 1)
      {
        monday.removeGroup(group);
      }
      else if (temp == 2)
      {
        tuesday.removeGroup(group);
      }
      else if (temp == 3)
      {
        wednesday.removeGroup(group);
      }
      else if (temp == 4)
      {
        thursday.removeGroup(group);
      }
      else if (temp == 5)
      {
        friday.removeGroup(group);
      }
      else if (temp == 6)
      {
        saturday.removeGroup(group);
      }
      else if (temp == 7)
      {
        sunday.removeGroup(group);
      }
      if (monday!=null&&monday.isEmpty())
      {
        days.remove(monday);
      }
      else if (tuesday!=null&&tuesday.isEmpty())
      {
        days.remove(tuesday);
      }
      else if (wednesday!=null&&wednesday.isEmpty())
      {
        days.remove(wednesday);
      }
      else if (thursday!=null&&thursday.isEmpty())
      {
        days.remove(thursday);
      }
      else if (friday!=null&&friday.isEmpty())
      {
        days.remove(friday);
      }
      else if (saturday!=null&&saturday.isEmpty())
      {
        days.remove(saturday);
      }
      else if (sunday!=null&&sunday.isEmpty())
      {
        days.remove(sunday);
      }
    }
  }
  public String getXML()
  {
    String returned="<week>\n";
    for(int i=0;i<days.size();i++)
    {
     returned+=days.get(i).getXML();
    }
    returned+="</week>";
    return returned;
  }
  public boolean containsGroup(ScheduledGroup group)
  {
    for(int i=0;i<days.size();i++)
    {
      if(days.get(i).containsGroup(group)) return true;
    }
    return false;
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
      ScheduledGroup test1 = new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(6));
      ScheduledGroup test2 = new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(27));
      ScheduledGroup test22 = new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(27));
      ScheduledGroup test3 = new ScheduledGroup(new Group("pilates",20,new Instructor("name","strand",31,"ea",2143,"descript")),new Date(28));
      Week nr1 = new Week(26);
      nr1.addGroup(test2);
      nr1.addGroup(test22);
      System.out.println();
      System.out.println(nr1);
//      System.out.printf(nr1.getSaturday().toString());
      System.out.println();
      System.out.println(nr1);
      System.out.println(nr1.getXML());

    }
}
