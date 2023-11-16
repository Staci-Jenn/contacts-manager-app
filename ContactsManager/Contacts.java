package ContactsManager;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Contacts {
    Scanner input = new Scanner(System.in);


    ContactsUtils contactsUtils = new ContactsUtils();


    // Main line of code
    public void runContactsApp() {

        // Menu
        System.out.print("1. View contacts.\n" + "2. Add a new contact.\n" + "3. Search a contact by name.\n" + "4. Delete an existing contact.\n" + "5. Exit.\n" + "Enter an option (1, 2, 3, 4 or 5):\n");

        String userInput = input.nextLine();

        //Switch/Case
        switch (userInput) {
            case
        }


        // Create Path objects for the directory and file
        Path pathToContacts = Paths.get("contacts.txt");
//        System.out.println(pathToContacts);

        List<String> currentContacts = contactsUtils.readFile(pathToContacts);
        contactsUtils.outputList(currentContacts);

        try {
            if (Files.notExists(pathToContacts)) {
                Files.createFile(pathToContacts);
            }
        } catch (IOException iox) {
            iox.printStackTrace();
        }

        //Append Contacts
        List<String> moreContacts = Arrays.asList("Staci | 21546461");
        try {
            Files.write(pathToContacts, moreContacts, StandardOpenOption.APPEND);
        } catch (IOException iox){
            System.out.println("Error writing to file " + iox.getMessage());
        }



    }

}
