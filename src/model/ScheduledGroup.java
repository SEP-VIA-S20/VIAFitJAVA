package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ScheduledGroup implements Serializable
{
  private String name;
  private Instructor instructor;
  private int maxLimit;
  private ArrayList<Member> members;
  private Date time;
  private int spaceLeft;
  private int groupID;

  public int getSpaceLeft()
  {
    return spaceLeft;
  }

  public ScheduledGroup(Group group,Date time)
  {
    this.name = group.getName();
    this.instructor = group.getInstructor();
    this.maxLimit = group.getMaxLimit();
    this.time = time;
    this.members = new ArrayList<Member>();
    spaceLeft = maxLimit;
    groupID=0;
  }

  public int getGroupID()
  {
    return groupID;
  }

  public void setGroupID(int groupID)
  {
    this.groupID = groupID;
  }

  public ArrayList<Member> getMembers()
    {
      return members;
    }
    public void addMember(Member member)
    {
      if(members.size()<maxLimit)
      {
        members.add(member);
        spaceLeft--;
      }
    }
  public void addMembers(ArrayList<Member> toAdd)
  {
    members.addAll(toAdd);
  }
  public void setName(String name)
  {
    this.name = name;
  }

  public void setInstructor(Instructor instructor)
  {
    this.instructor = instructor;
  }

  public void setMaxLimit(int maxLimit)
  {
    this.maxLimit = maxLimit;
  }

  public void setMembers(ArrayList<Member> members)
  {
    this.members = members;
  }

  public void setSpaceLeft(int spaceLeft)
  {
    this.spaceLeft = spaceLeft;
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
    if(name!=null&&instructor!=null&&time!=null)
    {
      return "Name: "+name+" Instructor "+instructor.getName()+" MaxLimit "+maxLimit+" | Time: "+time+" | Members: " + members;

    }
    return "";
  }

  public String getName()
  {
    return name;
  }

  public Instructor getInstructor()
  {
    return instructor;
  }

  public int getMaxLimit()
  {
    return maxLimit;
  }
  @Override public boolean equals(Object obj)
  {
    if(!(obj instanceof ScheduledGroup)) return false;
    ScheduledGroup temp = (ScheduledGroup)obj;
    return toString().equals(temp.toString());
  }
}
