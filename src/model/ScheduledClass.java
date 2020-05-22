package model;

import javafx.scene.Scene;

import java.io.Serializable;
import java.util.ArrayList;

public class ScheduledClass implements Serializable
{
  private Group group;
  private ArrayList<Member> members;
  private Date time;

  public ScheduledClass(Group group,Date time)
  {
    this.group = group;
    this.time = time;
    this.members = new ArrayList<Member>();
  }
    public ArrayList<Member> getMembers()
    {
      return members;
    }
    public void addMember(Member member)
    {
      if(members.size()<group.getMaxLimit())
      {
        members.add(member);
      }
    }
    public void removeMember(Member member)
    {
      members.remove(member);
    }
    public boolean hasMember(Member member)
    {
      return members.contains(member);
    }
    public Member getMember(int index)
    {
      if(index <members.size())
      {
        return members.get(index);
      }
      return null;
    }

  public Group getGroup()
  {
    return group;
  }

  public void setGroup(Group group)
  {
    this.group = group;
  }

  public Date getTime()
  {
    return time;
  }

  public void setTime(Date time)
  {
    this.time = time;
  }

  @Override public String toString()
  {
    return super.toString().replace("]"," | Members: " + members+ " ]");
  }

  @Override public boolean equals(Object obj)
  {
    if(!(obj instanceof ScheduledClass)) return false;
    ScheduledClass temp = (ScheduledClass)obj;
    return temp.toString().equals(toString());
  }
}
