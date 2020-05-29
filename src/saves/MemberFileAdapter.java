package saves;

import lists.MemberList;
import model.Member;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MemberFileAdapter
{
  private String fileName;

  public MemberFileAdapter(String fileName)
  {
    this.fileName = fileName;
  }

  public String getFileName()
  {
    return fileName;
  }

  public void setFileName(String fileName)
  {
    this.fileName = fileName;
  }
  public void saveMembers(MemberList members)
  {
    FileIO fileOut = new FileIO();
    try
    {
      fileOut.writeToFile(fileName, members);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }catch (IOException e)
    {
      System.out.println("IO exception saving members");
    }
  }
  public MemberList getAllMembers()
  {
    FileIO fileIn = new FileIO();
    Object obj = null;
    try
    {
      obj = fileIn.readObjectFromFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found members");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class not found");
    }
    catch (IOException e)
    {
      System.out.println("IO exception getting members");
    }
    return (MemberList)obj;
  }
  public void addMember(Member member)
  {
    MemberList members = getAllMembers();
    members.addMember(member);
    saveMembers(members);
  }
  public void addMembers(MemberList obj)
  {
    MemberList members = getAllMembers();
    for(int i=0;i<obj.size();i++)
    {
      members.addMember(obj.getMember(i));
    }
    saveMembers(members);
  }
  public void deleteMembers(Member member)
  {
    MemberList members = getAllMembers();
    members.removeMember(member);
    saveMembers(members);
  }
  public void deleteMemberByPhoneNumber(int phone)
  {
    MemberList members = getAllMembers();
    if(members.indexOfPhoneNumber(phone)!=-1)
    {
      members.removeMember(members.indexOfPhoneNumber(phone));
    }
    saveMembers(members);
  }
  public void importCSV(String fileName)
  {
    String[] members = null;
    MemberList memberList = new MemberList();
    TextFileIO fileIn = new TextFileIO();
    try
    {
      members = fileIn.readArrayFromFile(fileName);
    }catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    for(int i=0;i<members.length;i++)
    {
      String temp = members[i];
      String[] tempArray = temp.split(",");
      String name = tempArray[0];
      String address = tempArray[1];
      int  phone = Integer.parseInt(tempArray[2].trim());
      String email = tempArray[3];
      boolean premium = Boolean.parseBoolean(tempArray[4]);
      Member member = new Member(name,address,phone,email,0,premium);
      memberList.addMember(member);
    }
    saveMembers(memberList);
  }
}
