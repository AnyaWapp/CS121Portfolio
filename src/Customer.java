import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    //Variables
    private String firstName;
    private String lastName;
    private int pin;

    private HashMap<Integer, Account> accountHashMap = new HashMap();
    //private ArrayList<Account> accountArrayList = new ArrayList<>();

    //Constructor
    public Customer(String firstName, String lastName, int pin){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
    }
    //getters and setters
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public int getPin() {return pin;}
    //public ArrayList<Account> getAccountArrayList() {return accountArrayList;}

    //methods
    public void addAccount(int num, Account account) {
        accountHashMap.put(num, account);
    }
    public void removeAccount(int num, Account account) {
        accountHashMap.remove(num, account);
        System.out.println("Account number " + account.getActNum() + " has been removed.");
    }
    public Account getAccount(int pin){
    Account account = accountHashMap.get(pin);
    return account;

    }
    public StringBuilder getAllAccounts() {
        StringBuilder accountStringBuilder = new StringBuilder();
        System.out.println("~~~Active Accounts~~~~");
        accountHashMap.forEach((num,account)->{
            accountStringBuilder.append(account.toString());
        });
        return accountStringBuilder;
    }

    @Override
    public String toString() {return String.format("Customer Name: %s %s\nPIN: %d\n",firstName, lastName, pin);}
}
