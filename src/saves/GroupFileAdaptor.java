package saves;

import lists.GroupList;
import model.Group;
import model.Instructor;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GroupFileAdaptor
{
  private String fileName;

  public GroupFileAdaptor(String fileName)
  {
    this.fileName = fileName;
  }
  public void saveGroup(GroupList obj){
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
      System.out.println("IO exception saving groups");
    }
  }
  public GroupList getAllGroups()
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
      System.out.println("IO exception getting groups");
    }
    return (GroupList) obj;
  }
  public void addGroup(Group group)
  {
    GroupList groups = getAllGroups();
    if(groups==null)
    {
      GroupList temp = new GroupList();
      temp.addGroup(group);
      saveGroup(temp);
    }else
    {
      groups.addGroup(group);
      saveGroup(groups);
    }

  }
  public void addGroups(GroupList obj)
  {
    GroupList groups = getAllGroups();
    for(int i=0;i<obj.size();i++)
    {
      groups.addGroup(obj.getGroup(i));
    }
    saveGroup(groups);
  }
  public void deleteGroup(Group group)
  {
    GroupList groups = getAllGroups();
    groups.removeGroup(group);
    saveGroup(groups);
  }

  public static void main(String[] args)
  {
    GroupFileAdaptor f1 = new GroupFileAdaptor("src/data/groups.bin");
//    Instructor paul = new Instructor("Paul","Gers",21931,"g@mail.com",0,"Professional killer");
//    f1.addGroup(new Group("Jogging",20,paul));
//    f1.addGroup(new Group("ABS",15,paul));
//    f1.addGroup(new Group("Pilates",10,paul));
    System.out.println(f1.getAllGroups());

  }

}
