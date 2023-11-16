package ContactsManager;

public class Contact {
    private String name;
    private String number;

    // Constructor for name and number
    public Contact(String name, String number) {
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
//    public String toString(){
//        return name + " | " + number;
//    }
}
