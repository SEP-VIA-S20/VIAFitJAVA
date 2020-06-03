package model;

import java.io.Serializable;

public class Instructor extends Person implements Serializable
{
  private String description;

  public Instructor(String name, String address, int phone, String email,
      int ID, String description)
  {
    super(name, address, phone, email, ID);
    this.description = description;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  @Override public String toString()
  {
    return getName()+" +45 "+getPhone();
  }
  @Override public boolean equals(Object obj)
  {
    if(!(obj instanceof Instructor)) return false;
    Instructor instructor = (Instructor) obj;
    return instructor.toString().equals(toString());
  }


//  public static void main(String[] args)
//  {
//    Instructor DEN = new Instructor("DEN","STRAND",31,"GERSDOR",2001,"none");
//    System.out.println(DEN);
//  }
}
