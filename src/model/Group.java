package model;

import java.io.Serializable;
//import java.util.ArrayList;

public class Group implements Serializable
{
  private String name;
  private int maxLimit;
  private Instructor instructor;
//  private ArrayList<Member> members;

  public Group(String name, int maxLimit, Instructor instructor)
  {
    this.name = name;
    this.maxLimit = maxLimit;
    this.instructor = instructor;
//    members = new ArrayList<Member>();
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getMaxLimit()
  {
    return maxLimit;
  }

  public void setMaxLimit(int maxLimit)
  {
    this.maxLimit = maxLimit;
  }

  public Instructor getInstructor()
  {
    return instructor;
  }

  public void setInstructor(Instructor instructor)
  {
    this.instructor = instructor;
  }

}
