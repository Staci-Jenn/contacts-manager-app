package ContactsManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Contacts {
    Scanner input = new Scanner(System.in);


    ContactsUtils contactsUtils = new ContactsUtils();
    Path pathToContacts = Paths.get("contacts.txt");


    List<Contact> currentContacts = contactsUtils.loadContacts(pathToContacts);


    // Main line of code
    public void runContactsApp() {

        try {
            if (Files.notExists(pathToContacts)) {
                Files.createFile(pathToContacts);
            }
        } catch (IOException iox) {
            iox.printStackTrace();
        }

        boolean exit = false;
        while (!exit) {
            // Menu
            System.out.print("1. View contacts.\n" + "2. Add a new contact.\n" + "3. Search a contact by name.\n" + "4. Delete an existing contact.\n" + "5. Exit.\n" + "Enter an option (1, 2, 3, 4 or 5):\n");


            String userInput = input.nextLine();

            //Switch/Case
            switch (userInput) {
                case "1":
                    contactsUtils.outputList(currentContacts);
                    break;
                case "2":
                    addContact();
                    break;
                case "3":
                    searchContact();
                    break;
                case "4":
                    deleteContact();
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
                    break;
            }
        }
    }

    private void addContact() {
        try {
            String answer;
            do {
                System.out.println("Enter a name");
                String userAddName = input.nextLine();
                System.out.println("Enter a number");
                String userAddNumber = input.nextLine();
                Contact contact = new Contact(userAddName, userAddNumber);

                Files.writeString(pathToContacts, contact.toString() + "\n", StandardOpenOption.APPEND);
                System.out.println("Do you want to enter another contact? \"yes\" or \"no\"");
                answer = input.nextLine();
            } while (answer.equalsIgnoreCase("yes"));
        } catch (IOException iox) {
            System.out.println("Error writing to file " + iox.getMessage());
        }
    }

    private void searchContact() {
        System.out.println("Enter the name to search:");
        String searchName = input.nextLine();
        Contact foundContact = contactsUtils.searchContactByName(currentContacts, searchName);
        if (foundContact != null) {
            System.out.println("Contact found: " + foundContact.getName() + " | " + foundContact.getNumber());
        } else {
            System.out.println("Contact not found.");
        }
    }

    private void deleteContact() {
        System.out.println("Enter the name of the contact to delete:");
        String deleteName = input.nextLine();
        Contact contactDeleted = contactsUtils.deleteContact(currentContacts, deleteName);
        if (contactDeleted != null) {
            System.out.println("Contact deleted successfully.");
            // Update the contacts.txt file
            contactsUtils.writeContactsToFile(pathToContacts, currentContacts);
        } else {
            System.out.println("Contact not found.");
        }
    }
}