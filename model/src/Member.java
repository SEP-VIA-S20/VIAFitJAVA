import java.io.Serializable;

public class Member implements Serializable
{
  private String name;
  private String address;
  private int phone;
  private String email;
  private boolean premiumMembership;

  public Member(String name, String address, int phone, String email,
      boolean premiumMembership)
  {
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.email = email;
    this.premiumMembership = premiumMembership;
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

  public boolean isPremiumMembership()
  {
    return premiumMembership;
  }

  public void setPremiumMembership(boolean premiumMembership)
  {
    this.premiumMembership = premiumMembership;
  }

  @Override public String toString()
  {
    if(premiumMembership) return "Premium Member:\n[ Name: "+name+" | Address: "+address+" | Phone: "+phone+" | Email: "+email+" ]";
    return "Member:\n[ Name: "+name+" | Address: "+address+" | Phone: "+phone+" | Email: "+email+" ]";
  }

//  public static void main(String[] args)
//  {
//    Member den = new Member("Daniel Moscal","gersdor",50370031,"dnl@via.dk",true);
//    System.out.println(den);
//  }
}
