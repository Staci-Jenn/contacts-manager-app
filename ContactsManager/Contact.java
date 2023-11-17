package ContactsManager;

public class Contact {
    private String name;
    private String number;

    // Constructor for name and number
    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    // Getter/Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String toString(){
        return "\n" + name + "|" + number;
    }
}
