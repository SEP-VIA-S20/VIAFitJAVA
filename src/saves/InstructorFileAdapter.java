package saves;

import lists.InstructorList;
import model.Instructor;

import java.io.FileNotFoundException;
import java.io.IOException;

public class InstructorFileAdapter
{
  private String fileName;

  public String getInstructor()
  {
    return fileName;
  }

  public void setInstructor(String fileName)
  {
    this.fileName = fileName;
  }

  public InstructorFileAdapter(String fileName)
  {
    this.fileName = fileName;
  }

  public void saveInstructors(InstructorList obj)
  {
    FileIO fileOut = new FileIO();
    try
    {
      fileOut.writeToFile(fileName, obj);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO exception saving cars");
    }
  }

  public InstructorList getAllInstructors()
  {
    FileIO fileIn = new FileIO();
    Object obj = null;
    try
    {
      obj = fileIn.readObjectFromFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found getting");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class not found getting");
    }
    catch (IOException e)
    {
      System.out.println("IO exception getting intructors");
      e.printStackTrace();
    }
    return (InstructorList) obj;
  }

  public void addInstructor(Instructor obj)
  {
    InstructorList instructor = getAllInstructors();
    instructor.addInstructor(obj);
    saveInstructors(instructor);
  }

  public void addInstructors(InstructorList obj)
  {
    InstructorList instructor = getAllInstructors();
    for (int i = 0; i < obj.size(); i++)
    {
      instructor.addInstructor(obj.getInstructor(i));
    }

  }

  public void deleteInstructor(Instructor instructor)
  {
    InstructorList instructors = getAllInstructors();
    for (int i = 0; i < instructors.size(); i++)
    {
      if (instructors.getInstructor(i).equals(instructor))
      {
        instructors.removeInstructor(i);
      }
    }
    saveInstructors(instructors);
  }

  public void deleteInstructorByPhoneNumber(int phone)
  {
    InstructorList instructors = getAllInstructors();
    if (instructors.indexOfPhoneNumber(phone) != -1)
    {
      instructors.removeInstructor(instructors.indexOfPhoneNumber(phone));
    }
    saveInstructors(instructors);
  }

  public void importCSV(String fileName)
  {
    String[] instructors = null;
    InstructorList instructorList = new InstructorList();
    TextFileIO fileIn = new TextFileIO();
    try
    {
      instructors = fileIn.readArrayFromFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    for (int i = 0; i < instructors.length; i++)
    {
      String temp = instructors[i];
      String[] tempArray = temp.split(",");
      String name = tempArray[0];
      String address = tempArray[1];
      int  phone = Integer.parseInt(tempArray[2].trim().replaceFirst(".{3}$",""));
      String email = tempArray[3];
      String description = tempArray[4];
      Instructor instructor = new Instructor(name, address, phone, email, 0,
          description);
      instructorList.addInstructor(instructor);
    }
    saveInstructors(instructorList);

  }

  public static void main(String[] args)
  {
    InstructorFileAdapter data = new InstructorFileAdapter(
        "src/data/instructor.bin");
    data.importCSV("src/data/instructors.csv");
    System.out.println(data.getAllInstructors());

  }
}
