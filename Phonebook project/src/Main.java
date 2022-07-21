import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main
{
  public static void main (String[]args) throws IOException
  {
    int choice = 0;
    PhoneBook phoneBook = new PhoneBook();
    BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
    while (true)
      {
	System.out.println
	  ("Menu \n1.Add Contact \n2.Display all contacts \n3.Search contact by phone \n4.Remove contact \n5.Exit");
	choice = Integer.parseInt (br.readLine ());
	switch (choice)
	  {
	  case 1:
	    Contact contact = new Contact ();
	    System.out.println ("Enter the firstName");
	    String firstName = br.readLine ();
	      System.out.println ("Enter the lastName");
	    String lastName = br.readLine ();
	      System.out.println ("Enter the phoneNumber");
	    long phoneNumber = Long.parseLong (br.readLine ());
	      System.out.println ("Enter the emailId");
	    String emailId = br.readLine ();
	      contact.setfirstName (firstName);
	      contact.setlastName (lastName);
	      contact.setphoneNumber (phoneNumber);
	      contact.setemailid (emailId);
	      phoneBook.addContact (contact);
	      break;
	    case 2:List < Contact > contacts = phoneBook.viewAllContacts ();
	    for (Contact contact1:contacts)
	        System.out.println ("firstName is: " +
				    contact1.getfirstName () +
				    " getlastName is: " +
				    contact1.getlastName () +
				    " emailId is: " + contact1.getemailid ());

	      break;
	    case 3:System.out.println ("Enter the phoneNumber:");
	    long phone = Long.parseLong (br.readLine ());
	    Contact contact2 = phoneBook.viewContactGivenPhone (phone);


	      System.out.println ("firstName is: " +
				  contact2.getfirstName () +
				  " getlastName is: " +
				  contact2.getlastName () +
				  " emailId is: " + contact2.getemailid ());

	      break;
	    case 4:System.out.println ("Enter the phoneNumber:");
	    long phone1 = Long.parseLong (br.readLine ());
	      phoneBook.removeContact (phone1);
	      break;
	    case 5:System.exit (0);
	  }

      }

  }
}
