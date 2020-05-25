package lists;

import model.Week;

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
  public void removeWeek(Week instructor)
  {
    weeks.remove(instructor);
  }
  public void removeWeek(int index)
  {
    weeks.remove(index);
  }

  @Override public String toString()
  {
    String returned = "Weaks: ";
    for(int i=0;i<weeks.size();i++)
    {
      returned+="\n"+weeks.get(i).toString();
    }
    return returned;
  }




}
