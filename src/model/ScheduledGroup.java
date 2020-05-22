package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ScheduledGroup implements Serializable
{
  private Group group;
  private ArrayList<Member> members;
  private Date time;

  public ScheduledGroup(Group group,Date time)
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
    return group.toString()+" | Members: " + members;
  }

  @Override public boolean equals(Object obj)
  {
    if(!(obj instanceof ScheduledGroup)) return false;
    ScheduledGroup temp = (ScheduledGroup)obj;
    return temp.toString().equals(toString());
  }
}
