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


}
