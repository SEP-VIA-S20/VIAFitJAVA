package lists;

import model.Instructor;

import java.io.Serializable;
import java.util.ArrayList;

public class InstructorList implements Serializable
{
  private ArrayList<Instructor> instructors;
  private int lastID;

  public InstructorList()
  {
    instructors = new ArrayList<Instructor>();
    lastID = 0;
  }
  public ArrayList<Instructor> getList()
  {
    return instructors;
  }
  public int size()
  {
    return instructors.size();
  }
  public int indexOfPhoneNumber(int phone)
  {
    for(int i=0;i<instructors.size();i++)
    {
      if(instructors.get(i).getPhone()==phone) return i;
    }
    return -1;
  }
  public Instructor getInstructor(int index)
  {
    return instructors.get(index);
  }
  public Instructor getInstructorByPhone(int phone)
  {
    if(indexOfPhoneNumber(phone)!=-1) return instructors.get(indexOfPhoneNumber(phone));
    return null;
  }
  public Instructor getInstructorByName(String name)
  {
    for(int i=0;i<instructors.size();i++)
    {
      if(instructors.get(i).getName().equals(name)) return instructors.get(i);
    }
    return null;
  }
  public ArrayList<String> getInstructorsArray()
  {
    ArrayList<String> instructorsArray = new ArrayList<String>();
    for(int i=0;i<instructors.size();i++)
    {
      instructorsArray.add(instructors.get(i).getName());
    }
    return instructorsArray;
  }
  public void addInstructor(Instructor instructor)
  {
    instructor.setID(lastID);
    lastID++;
    instructors.add(instructor);
  }
  public void removeInstructor(Instructor instructor)
  {
    instructors.remove(instructor);
  }
  public void removeInstructor(int index)
  {
    instructors.remove(index);
  }

  @Override public String toString()
  {
    String returned = "Instructors: ";
    for(int i=0;i<instructors.size();i++)
    {
      returned+="\n"+instructors.get(i).toString();
    }
    return returned;
  }
  public int getInstructorIndexByName(String name)
  {
    return indexOfPhoneNumber(getInstructorIndexByName(name));
  }
  public int getIndex(Instructor instructor)
  {
    for (int i = 0; i < instructors.size(); i++)
    {
      if (instructors.get(i).equals(instructor))
      {
        return i;
      }
    }
    return 0;
  }

  public void setInstructor(int indexOfPhoneNumber, Instructor toAdd)
  {
    instructors.set(indexOfPhoneNumber, toAdd);
  }
}
