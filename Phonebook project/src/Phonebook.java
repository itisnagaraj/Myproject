import java.util.ArrayList;
import java.util.List;

class PhoneBook
{
  private List < Contact > phoneBook = new ArrayList < Contact > ();
  public List < Contact > getContactList ()
  {
    return phoneBook;
  }
  public void setContactList (ArrayList < Contact > ContactList)
  {
    this.phoneBook = ContactList;
  }

  public void addContact (Contact contactObj)
  {
    phoneBook.add (contactObj);
  }
  public List < Contact > viewAllContacts ()
  {
    return phoneBook;
  }
  public Contact viewContactGivenPhone (long phoneNumber)
  {
  for (Contact contact:phoneBook)
      {
	if (contact.getphoneNumber () == phoneNumber)
	  return contact;
      }
    return null;
  }
  public boolean removeContact (long phoneNumber)
  {
  for (Contact contact:phoneBook)
      {
	if (contact.getphoneNumber () == phoneNumber)
	  {
	    phoneBook.remove (contact);
	    return true;
	  }
      }
       return false;
 
  }

}
