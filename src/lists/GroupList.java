package lists;

import model.Group;

import java.io.Serializable;
import java.util.ArrayList;

public class GroupList implements Serializable
{
  private ArrayList<Group> groups;

  public GroupList()
  {
    groups = new ArrayList<Group>();
  }
  public int size()
  {
    return groups.size();
  }

  public Group getGroup(int index)
  {
    return groups.get(index);
  }

  public void addGroup(Group group)
  {
    groups.add(group);
  }
  public void removeGroup(Group group)
  {
    groups.remove(group);
  }
  public void removeGroup(int index)
  {
    groups.remove(index);
  }

  @Override public String toString()
  {
    String returned = "Groups: ";
    for(int i=0;i<groups.size();i++)
    {
      returned+="\n"+groups.get(i).toString();
    }
    return returned;
  }

  public ArrayList<Group> getList()
  {
    return groups;
  }
}
