package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.IsoFields;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Serializable
{
  private int day;
  private int month;
  private int year;
  private Time time;


  public int getDay()
  {
    return day;
  }

  public void setDay(int day)
  {
    this.day = day;
  }

  public int getMonth()
  {
    return month;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public Date(int day, int month, int year, int hour, int minute)
  {
    this.day = day;
    this.month = month;
    this.year = year;
    time = new Time(hour, minute);
  }
  public Date now()
  {
    LocalDate newDate = LocalDate.now();
    LocalTime newTime = LocalTime.now();
    Time tempTime = new Time(newTime.getHour(),newTime.getMinute());
    return new Date(newDate.getDayOfMonth(),newDate.getMonthValue(),newDate.getYear(),tempTime);
  }
  public int getWeekNumber()
  {
    Calendar cal = new GregorianCalendar();
    cal.set(year,month-1,day);
    return cal.get(Calendar.WEEK_OF_YEAR);
  }
  public Date(int day)
  {
    LocalDate newDate = LocalDate.now();
    this.day = day;
    this.month = newDate.getMonthValue();
    this.year = newDate.getYear();
    this.time = new Time(0,0);
  }
  public Date(int hour, int minute)
  {
    LocalDate newDate = LocalDate.now();
    this.day = newDate.getDayOfMonth();
    this.month = newDate.getMonthValue();
    this.year = newDate.getYear();
    this.time = new Time(hour,minute);

  }
  public Date(int day, int month, int year, Time time)
  {
    this.day = day;
    this.month = month;
    this.year = year;
    this.time = time;
  }

  public Date(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
    this.time = new Time(0,0);
  }

  public Date copy()
  {
    return new Date(day,month,year,time);
  }

  @Override public String toString()
  {
    return day+"/"+month+"/"+year +" "+getTimeString();
  }

  public Time getTime()
  {
    return time;
  }

  public void setTime(int hour, int minutes)
  {
    time.set(hour,minutes,0);
  }
  public void setTime(int hour, int minutes, int seconds)
  {
    time.set(hour, minutes, seconds);
  }

  public String getTimeString()
  {
    return time.getTime();
  }
  public String getDateString()
  {
    return day+"/"+month+"/"+year;
  }
  @Override public boolean equals(Object obj)
  {
    if(!(obj instanceof Date))
    {
      return false;
    }
    Date date = (Date)obj;
    return date.toString().equals(toString());
  }

  public static void main(String[] args)
  {
    Date d1 = new Date(2,6,2020);
    System.out.println(d1.getWeekNumber());
  }

}

