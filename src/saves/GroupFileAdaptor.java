package saves;

import lists.GroupList;
import model.Group;

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
      System.out.println("IO exception saving cars");
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
      System.out.println("IO exception getting cars");
    }
    return (GroupList) obj;
  }
  public void addGroup(Group group)
  {
    GroupList groups = getAllGroups();
    groups.addGroup(group);
    saveGroup(groups);
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

}
