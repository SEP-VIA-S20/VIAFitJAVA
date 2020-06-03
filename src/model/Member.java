package model;

import java.io.Serializable;

public class Member extends Person implements Serializable
{
  private boolean premiumMember;

  public Member(String name, String address, int phone, String email, int ID,
      boolean premiumMember)
  {
    super(name, address, phone, email, ID);
    this.premiumMember = premiumMember;
  }

  public boolean isPremiumMember()
  {
    return premiumMember;
  }

  public void setPremiumMember(boolean premiumMember)
  {
    this.premiumMember = premiumMember;
  }

  @Override public String toString()
  {
    return getName()+" +45 "+getPhone()+"\n";
  }

  @Override public boolean equals(Object obj)
  {
    if(!(obj instanceof Member)) return false;
    Member member = (Member)obj;
    return member.toString().equals(toString());
  }
    public static void main(String[] args)
  {
    Member den = new Member("Den","strend",312,"@dev",2010,true);
    System.out.println(den);
  }
}
