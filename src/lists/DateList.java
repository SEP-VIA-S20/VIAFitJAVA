package lists;

import model.Date;
import java.io.Serializable;
import java.util.ArrayList;

public class DateList implements Serializable
{
  private ArrayList<Date> dates;

  public DateList()
  {
    dates = new ArrayList<Date>();
  }

  public int size()
  {
    return dates.size();
  }

  public Date getDate(int index)
  {
    return dates.get(index);
  }
  public void addDate(Date date)
  {
    dates.add(date);
  }
  public void removeDate(Date date)
  {
    dates.remove(date);
  }
  public void removeDate(int index)
  {
    dates.remove(index);
  }

  @Override public String toString()
  {
    String returned = "Date: ";
    for(int i=0;i<dates.size();i++)
    {
      returned+="\n"+dates.get(i).toString();
    }
    return returned;
  }
  /*
  public static void main(String[] args)
  {
    Date date1 = new Date(01, 06 , 20, 8, 20);
    Date date2 = new Date(02, 06 , 20, 8, 20);
    Date date3 = new Date(03, 06 , 20, 8, 20);
    Date date4 = new Date(04, 06 , 20, 8, 20);
    Date date5 = new Date(05, 06 , 20, 8, 20);
    Date date6 = new Date(06, 06 , 20, 8, 20);
    Date date7 = new Date(07, 06 , 20, 8, 20);
    System.out.println(date1);
    System.out.println(date2);
    System.out.println(date3);
    System.out.println(date4);
    System.out.println(date5);
    System.out.println(date6);
    System.out.println(date7);
    System.out.println("======================================================================");
    DateList dateList = new DateList();

    dateList.addDate(date1);
    dateList.addDate(date2);
    dateList.addDate(date3);
    dateList.addDate(date4);
    dateList.addDate(date5);
    dateList.addDate(date6);
    dateList.addDate(date7);
    System.out.println(dateList);
  }*/
}
