package ContactsManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Contacts {
    Scanner input = new Scanner(System.in);


    ContactsUtils contactsUtils = new ContactsUtils();


    // Main line of code
    public void runContactsApp() {

        // Create Path objects for the directory and file
        Path pathToContacts = Paths.get("contacts.txt");
        List<Contact> currentContacts = contactsUtils.loadContacts(pathToContacts);


        // Menu
        System.out.print("1. View contacts.\n" + "2. Add a new contact.\n" + "3. Search a contact by name.\n" + "4. Delete an existing contact.\n" + "5. Exit.\n" + "Enter an option (1, 2, 3, 4 or 5):\n");

        String userInput = input.nextLine();



        //Switch/Case
        switch (userInput) {
            case "1" -> contactsUtils.outputList(currentContacts);
//            case "2" -> addContact();
            case "3" -> {
                System.out.println("Enter the name to search:");
                String searchName = input.nextLine();
                Contact foundContact = contactsUtils.searchContactByName(currentContacts, searchName);
                if (foundContact != null) {
                    System.out.println("Contact found: " + foundContact.getName() + " | " + foundContact.getNumber());
                } else {
                    System.out.println("Contact not found.");
                }
            }
//            case "4" -> deleteContact();
            case "5" -> System.exit(0);
        }


//        System.out.println(pathToContacts);


//        contactsUtils.outputList(currentContacts);

        try {
            if (Files.notExists(pathToContacts)) {
                Files.createFile(pathToContacts);
            }
        } catch (IOException iox) {
            iox.printStackTrace();
        }


        // 1. View Contacts



        //Append Contact
//        private void addContact() {
        // List contacts = loadContacts()

//            System.out.println("Enter a name");
//            String userAddName = input.nextLine();
//            System.out.println("Enter a number");
//            int userAddNumber = input.nextInt();
//            Contact contact = new Contact(userAddName, userAddNumber);
//              contacts.add(

//            List<String> moreContacts = Arrays.asList( );
//            try {
//                Files.write(pathToContacts, moreContacts, StandardOpenOption);
//            } catch (IOException iox) {
//                System.out.println("Error writing to file " + iox.getMessage());
//            }
//
//        }

    }




}
