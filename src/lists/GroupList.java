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
  public int getIndexOfName(String name)
  {
    for (int i = 0; i < groups.size(); i++)
    {
      if (groups.get(i).getName().equals(name))
      {
        return i;
      }
    }
    return -1;
  }
  public ArrayList<String> getStringArray()
  {
    ArrayList<String> returned = new ArrayList<String>();
    for(int i=0;i<groups.size();i++)
    {
      returned.add(groups.get(i).getName());
    }
    return returned;
  }
  public boolean hasGroup(Group group)
  {
    return groups.contains(group);
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
  public void setGroup(int index, Group group)
  {
    groups.set(index,group);
  }
  public ArrayList<Group> getList()
  {
    return groups;
  }
}
