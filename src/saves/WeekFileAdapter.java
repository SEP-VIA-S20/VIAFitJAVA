package saves;

import lists.WeekList;
import model.Group;
import model.ScheduledGroup;
import model.Week;

import java.io.FileNotFoundException;
import java.io.IOException;

public class WeekFileAdapter
{
  private String fileName;

  public WeekFileAdapter(String fileName)
  {
    this.fileName = fileName;
  }

  public String getFileName()
  {
    return fileName;
  }

  public void setFileName(String fileName)
  {
    this.fileName = fileName;
  }

  public void saveWeeks(WeekList obj)
  {
    FileIO fileOut = new FileIO();
    try
    {
      fileOut.writeToFile(fileName, obj);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO exception saving cars");
    }
  }

  public WeekList getAllWeeks()
  {
    FileIO fileIn = new FileIO();
    Object obj = null;
    try
    {
      obj = fileIn.readObjectFromFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found getting");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class not found getting");
    }
    catch (IOException e)
    {
      System.out.println("IO exception getting intructors");
      e.printStackTrace();
    }
    return (WeekList) obj;
  }

  public void addWeek(Week obj)
  {
    WeekList week = getAllWeeks();
    week.addWeeks(obj);
    saveWeeks(week);
  }

  public void addScheduledGroup(ScheduledGroup group)
  {
    WeekList allWeeks = getAllWeeks();
    if(allWeeks==null)
    {
      allWeeks = new WeekList();
    }
    allWeeks.addClass(group);
    saveWeeks(allWeeks);
  }

  public void deleteScheduledGroup(ScheduledGroup group)
  {
    WeekList allWeeks = getAllWeeks();
//    allWeeks.
  }
  public void addWeeks(WeekList obj)
  {
    WeekList week = getAllWeeks();
    for (int i = 0; i < obj.size(); i++)
    {
      week.addWeeks(obj.getWeek(i));
    }
  }

  public void deleteWeek(Week week)
  {
    WeekList weeks = getAllWeeks();
    weeks.removeWeek(week);
    saveWeeks(weeks);
  }
}
