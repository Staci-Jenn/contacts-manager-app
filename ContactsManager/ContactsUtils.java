package ContactsManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactsUtils {

    Path pathToContacts = Paths.get("contacts.txt");


    // 1. View Contacts
    public List<Contact> loadContacts(Path pathToContacts) {
        List<Contact> contacts = new ArrayList<>();
        try {
            List<String> contactsFromFile = Files.readAllLines(pathToContacts);
            for (String stringContact : contactsFromFile){
                String name = stringContact.split("\\|")[0].trim();
                String number = stringContact.split("\\|")[1].trim();
                Contact contact = new Contact(name, number);
                contacts.add(contact);
            }
        } catch (IOException iox) {
            iox.printStackTrace();
        }
        return contacts;
    }
    // Outputs list
    public void outputList(List<Contact> contacts) {
        System.out.println("Outputting list!!");
        for (Contact contact : contacts) {
            System.out.println(contact.getName() + " | "  + contact.getNumber());
        }
        System.out.println("--------------");
        }


    // Write a list to the file
    void writeListToFile(Path pathToContacts, List<String> listToWrite) {
        try {
            Files.write(pathToContacts, listToWrite);
        } catch (IOException iox) {
            iox.printStackTrace();
            System.out.println(iox.getMessage());
        }
    }


    // 3. Search Contacts
    Contact searchContactByName(List<Contact> contacts, String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    // 4. Remove Contacts
    Contact deleteContact(List<Contact> contacts, String name) {
        for (Iterator<Contact> iterator = contacts.iterator(); iterator.hasNext();) {
            Contact contact = iterator.next();
            if (contact.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                return contact;
            }
        }
        return null;
    }

    void writeContactsToFile(Path pathToContacts, List<String> listToWrite) {
        try {
            List<String> contactsAsString = new ArrayList<>();
            for (Contact contact : listToWrite) {
                String contactString = contact.getName() + "," + contact.getNumber() + ",";
                contactsAsString.add(contactString);
            }
//            Files.write(pathToContacts, contactsAsString);
        } catch (IOException iox) {
            iox.printStackTrace();
            System.out.println(iox.getMessage());
        }
    }

//    Contact  writeContactsToFile(List<Contact> contacts) {
//        Path filePath = Paths.get("contacts.txt"); // Convert filename to a Path
//        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(filePath))) {
//            for (Contact contact : contacts) {
//                writer.println(contact.toString());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    }


