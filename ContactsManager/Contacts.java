

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Contacts {


    // Main line of code
    public void contactInfo() {
        // Create Path objects for the directory and file
        Path pathToContacts = Paths.get("contacts.txt");
        System.out.println(pathToContacts);

        try {
            if (Files.notExists(pathToContacts)) {
                Files.createFile(pathToContacts);
            }
        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }
}
