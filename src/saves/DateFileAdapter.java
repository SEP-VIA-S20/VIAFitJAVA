package saves;

import lists.DateList;
import model.Date;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DateFileAdapter
{
  private String fileName;

  public DateFileAdapter(String fileName)
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

  public void saveDates(DateList obj)
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

  public DateList getAllDates()
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
    return (DateList) obj;
  }

  public void addInstructor(Date obj)
  {
    DateList date = getAllDates();
    date.addDate(obj);
    saveDates(date);
  }

  public void addDates(DateList obj)
  {
    DateList date = getAllDates();
    for (int i = 0; i < obj.size(); i++)
    {
      date.addDate(obj.getDate(i));
    }
    saveDates(date);
  }

  public void deleteDate(Date date)
  {
    DateList dates = getAllDates();
    dates.removeDate(date);
    saveDates(dates);
  }






}
