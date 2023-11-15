package ContactsManager;

public class Contact {
    private String name;
    private int number;

    // Constructor for name and number
    public Contact(String name, int number) {
        this.name = name;
        this.number = number;
    }
    // 2 properties with getter/setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
