
class Contact
{
  private String firstName;
  private String lastName;
  private long phoneNumber;
  private String emailId;
  public String getfirstName ()
  {
    return firstName;
  }
  public void setfirstName (String firstName)
  {
    this.firstName = firstName;
  }
  public String getlastName ()
  {
    return lastName;
  }
  public void setlastName (String lastName)
  {
    this.lastName = lastName;
  }
  public long getphoneNumber ()
  {
    return phoneNumber;
  }
  public void setphoneNumber (long phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public void setemailid (String emailId)
  {
    this.emailId = emailId;
  }
  public String getemailid ()
  {
    return emailId;
  }
}
