package model;

import java.io.Serializable;

public abstract class Person implements Serializable
{
  private String name;
  private String address;
  private int phone;
  private String email;
  private int ID;

  public Person(String name, String address, int phone, String email, int ID)
  {
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.email = email;
    this.ID = ID;
  }

  public int getID()
  {
    return ID;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public int getPhone()
  {
    return phone;
  }

  public void setPhone(int phone)
  {
    this.phone = phone;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  @Override public String toString()
  {
    return "[ Name: "+name+" | Address: "+address+" | Phone: "+phone+" | Email: "+email+" | ID: "+ID+" ]";
  }

//  public static void main(String[] args)
//  {
//    Person den = new Person("Daniel Moscal","gersdor",50370031,"dnl@via.dk");
//    System.out.println(den);
//  }
}
