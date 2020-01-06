package conteacts;

import java.util.concurrent.Callable;

public class Tester {


    // Contacts = Name , Phone, Email
// Contact list App
// We can create new contact
// We can view list of contacts
// Search Contacts
// Delete Contacts
// Contact Array
// Insert ,Search, and Delete


    public static void main(String[] args) {
        Contact contact = new Contact("Arif Bhuiya","0508253550");
        //System.out.println(contact);
        Contact contact1 = new Contact("Bhuiya","01749596493","arifbhuiya@gmail.com");


        ContactList contactList = new ContactList();

        contactList.createContact(contact);
        contactList.createContact(contact1);

        System.out.println(contactList);

        System.out.println(contactList.getTotalContact());

      Contact searchConact  = contactList.searchContact("ArBhuiya");

      if(searchConact != null){
          System.out.println(searchConact);
      }else {
          System.out.println("Contact Not Found");
      }


    }

}

