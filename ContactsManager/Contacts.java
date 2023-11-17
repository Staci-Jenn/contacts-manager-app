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
            case "2" -> addContact();
            case "3" -> searchContact();
//            case "4" -> deleteContact();
            case "5" -> System.exit(0);
        }


        try {
            if (Files.notExists(pathToContacts)) {
                Files.createFile(pathToContacts);
            }
        } catch (IOException iox) {
            iox.printStackTrace();
        }


    }

    //Add Contact
    private void addContact() {
        try {
            String answer;
            do {
                System.out.println("Enter a name");
                String userAddName = input.nextLine();
                System.out.println("Enter a number");
                String userAddNumber = input.nextLine();
                Contact contact = new Contact(userAddName, userAddNumber);

                Files.writeString(pathToContacts, contact.toString(), StandardOpenOption.APPEND);
                System.out.println("Do you want to enter another contact? \"yes\" or \"no\"");
                answer = input.nextLine();
            } while (answer.equalsIgnoreCase("yes"));
        } catch (IOException iox) {
            System.out.println("Error writing to file " + iox.getMessage());
        }
    }

}

