import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void removeContact(Path pathToContacts, ContactsManager.Contact contact) {
        List<String> currentListOfContacts = readFile(pathToContacts);
//        String userDelete = scanner.nextLine();
        String contactToDelete = "Staci";
        writeListToFile(pathToContacts, currentListOfContacts);
    }

}
