public class Youth extends Customer {

    private int age;
    public Youth(int age, String firstName, String lastName, int pin){
        super(firstName,lastName,pin);
        this.age = age;
    }

    public Youth(String firstName, String lastName, int pin) {
        super(firstName, lastName, pin);
    }

    @Override
    public String toString() {
        return String.format("Age: %d\nFirst Name: %s", age,getFirstName());
    }
}
