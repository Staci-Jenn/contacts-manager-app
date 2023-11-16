import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactsUtils {


    // Read and Returns Contacts
    public List<String> readFile(Path pathToContacts){
        List<String> linesInFile = new ArrayList<>();
        try {
            linesInFile = Files.readAllLines(pathToContacts);
        } catch (IOException iox){
            iox.printStackTrace();
        }
        return linesInFile;
    }

    // Outputs list and accepts a list as its argument
    public void outputList(List<String> list){
        for (String listItem : list){
            System.out.println(listItem);
        }
    }

    // Write a list to the file
    public void writeListToFile(Path pathToFile, List<String> listToWrite){
        try {
            Files.write(pathToFile, listToWrite);
        } catch (IOException iox) {
            iox.printStackTrace();
            System.out.println(iox.getMessage());
        }
    }

    //Append Contacts
//    List<String> moreContacts = Arrays.asList("Staci | 21546461");
//        try {
//        Files.write(pathToContacts, moreContacts, StandardOpenOption.APPEND);
//    } catch (IOException iox){
//        System.out.println("Error writing to file " + iox.getMessage());
//    }



    //Removing Contacts
//    public void removeContact(Path pathToContacts, ContactsManager.Contact contactToRemove) {
        List<String> currentListOfContacts = readFile(pathToContacts);
        String contactToDelete = "Staci | 21546461";
////        String userDelete = scanner.nextLine();
//
//        currentListOfContacts.removeIf(contact -> contact.equals(contactToDelete));
//        writeListToFile(pathToContacts, currentListOfContacts);
//    }
//

    Iterator<String> contactIterator = currentListOfContacts.iterator();
    while(contactIterator.hasNext()){
        String contact = contactIterator.next();
        if (contact.equals(contactToDelete)) {
            contactIterator.remove();
        }
    }

}
