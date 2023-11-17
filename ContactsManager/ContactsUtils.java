package ContactsManager;

import java.io.IOException;
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
    public void writeListToFile(Path pathToContacts, List<String> listToWrite) {
        try {
            Files.write(pathToContacts, listToWrite);
        } catch (IOException iox) {
            iox.printStackTrace();
            System.out.println(iox.getMessage());
        }
    }


    // 3. Search Contacts
    public Contact searchContactByName(List<Contact> contacts, String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;

//        Contact contact = searchContactByName(contacts, name);

    }





    //    //Removing Contacts
    public void removeContact(Path pathToContacts, ContactsManager.Contact contactToRemove) {
//        List<String> currentListOfContacts = loadContact(pathToContacts);
//        String contactToDelete = "Staci | 21546461";
////        String userDelete = scanner.nextLine();
//
//        currentListOfContacts.removeIf(contact -> contact.equals(contactToRemove.toString()));
////        writeListToFile(pathToContacts, currentListOfContacts);
//    }
////
//
//    Iterator<String> contactIterator = currentListOfContacts.iterator();
//    while(contactIterator.hasNext()){
//        String contact = contactIterator.next();
//        if (contact.equals(contactToDelete)) {
//            contactIterator.remove();
//        }
//    }

    }

    }
