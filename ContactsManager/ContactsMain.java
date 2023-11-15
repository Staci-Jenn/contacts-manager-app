package ContactsManager;

import java.util.Scanner;

public class ContactsMain {
    public static void main(String[] args) {
        //Scanner
        Scanner input = new Scanner(System.in);
        input = new Scanner("contacts.txt");

        Contacts manager = new Contacts();
        manager.contactInfo();
    }


}
