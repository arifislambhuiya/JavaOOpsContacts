package conteacts;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class MycontactListApp {

    /*
    * Menu
    * 1. CreateNew Contact
    * 2. View All Contact
    * 3. Search Contact
    * 4. Delete Contact
    * 5. Exit
    * Enter Your Choice:
    * */

       public static void main(String[] args) {

           ContactList contactList = new ContactList();

           Scanner scanner = new Scanner(System.in);
           int menuItemNumber = 0;



            do{
                menuView();
                menuItemNumber = scanner.nextInt();

                switch (menuItemNumber){
                    case 1:
                        Contact contact = createNewContact(scanner);
                        contactList.createContact(contact);
                        System.out.println("Successfully Created..");
                        break;

                    case 2:
                        showAllContacts(contactList.getContacts());
                        break;

                    case 3:
                        searchList(contactList,scanner);
                        break;

                    case 4:
                        deleteContact(contactList,scanner);
                        break;

                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Select A Number Between 1 and 5 ....");
                        break;
                }

            }while (menuItemNumber != 5);
       }

       //view menu method
        private static void menuView () {
            System.out.println(String.format("%5s%3s%s", "1.", " ", "CreateNew Contact"));
            System.out.println(String.format("%5s%3s%s", "2.", " ", "View All Contact"));
            System.out.println(String.format("%5s%3s%s", "3.", " ", "Search Contact"));
            System.out.println(String.format("%5s%3s%s", "4.", " ", "Delete Contact"));
            System.out.println(String.format("%5s%3s%s", "5.", " ", "Exit"));
            System.out.println("--------------------------");
            System.out.print(" Enter Your Choice:");
        }


        // Get Input From User and Create a new Contact
    private static Contact createNewContact(Scanner scanner){
           String name,phone,email;
           Contact contact;

           scanner.nextLine();

           System.out.println("File in the form");

           System.out.print("Enter your Name * : ");
           name = scanner.nextLine();

           System.out.print("Enter Your Phone number* : ");
           phone = scanner.nextLine();

           System.out.println("Enter Email(Type N Note Available) : ");
           email = scanner.nextLine();

           if(email.equalsIgnoreCase("n")){
              contact = new Contact(name,phone);
           }else {
               contact = new Contact(name,phone,email);
           }
           return contact;
    }


    public static void showAllContacts(ArrayList<Contact> contacts){
        System.out.println("All Contacts......");
        System.out.println("----------------------");



        int i = 0;
        for(Contact contact:contacts){
            String email = contact.getEmail();
            System.out.println(String.format("%-5d%-20s%-15s%-50s", i++,contact.getName(),contact.getPhone(),email == null ? "N/A":email));
        }
        System.out.println("----------------------");

    }

    private static void searchList(ContactList contactList,Scanner scanner){
           scanner.nextLine();
        System.out.println("Enter Name to Search : ");
        String name = scanner.nextLine();



        Contact contact = contactList.searchContact(name);
        if(contact != null){
            String email = contact.getEmail();
            System.out.println(String.format("%-20s%-15s%-50s",contact.getName(),contact.getPhone(),email == null ? "N/A":email));
        }
        else {
            System.out.println("Contact Not Found...");
        }
    }

    // Delete Contact Method
    public static void deleteContact(ContactList contactList,Scanner scanner){
           showAllContacts(contactList.getContacts());
           System.out.print("Enter Index Number : ");
           int index = scanner.nextInt();


          contactList.removeContact(index);
          System.out.println("Successfully Removed ...");
    }

}
