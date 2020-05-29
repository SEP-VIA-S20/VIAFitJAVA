package lists;

import model.Member;

import java.io.Serializable;
import java.util.ArrayList;

public class MemberList implements Serializable
{
  private ArrayList<Member> members;
  private int lastID;

  public MemberList()
  {
    members = new ArrayList<Member>();
    lastID =0;
  }
  public int size()
  {
    return members.size();
  }
  public int indexOfPhoneNumber(int phone)
  {
    for (int i = 0; i < members.size(); i++)
    {
      if (members.get(i).getPhone() == phone)
      {
        return i;
      }
    }
    return -1;
  }
  public Member getMember(int index)
  {
    return members.get(index);
  }
  public Member getMemberByPhone(int phone)
  {
    if((indexOfPhoneNumber(phone)!=-1)) return members.get(indexOfPhoneNumber(phone));
    return null;
  }
  public void addMember(Member member)
  {
    member.setID(lastID);
    lastID++;
    members.add(member);
  }
  public void removeMember(int index)
  {
    members.remove(index);
  }
  public void removeMember(Member member)
  {
    members.remove(member);
  }

  @Override public String toString()
  {
    String returned = "Members: ";
    for(int i=0;i<members.size();i++)
    {
      returned+="\n"+members.get(i).toString();
    }
    return returned;
  }
//    public static void main(String[] args)
//    {
//      Member den = new Member("Den","Strandgade",312,"@dev",2709,true);
//      Member den1 = new Member("Daniel","Gersdorffs",503700,"@den",9901,false);
//      System.out.println(den);
//      MemberList memberList = new MemberList();
//      memberList.addMember(den);
//      memberList.addMember(den1);
//      System.out.println(memberList);
//    }
}