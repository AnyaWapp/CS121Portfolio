import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);

     private Bank bank = new Bank();

    public void displayMenu(){
        while (true) {
            System.out.println("~~~~~~~~~~ MENU ~~~~~~~~~~\nPlease make a selection:\n1) Access an existing account\n2) Create a new account \n3) Close all accounts\n4) Exit");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 1) {
                accessAccount();
            } else if (select == 2) {
                createAccount();
            } else if (select == 3) {
                closeAccounts();
            } else if (select == 4) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid entry :(");
            }
        }
    }
    private void accessAccount() {
       Youth customer;
        Account account;
        int pin;
        System.out.println("Enter PIN: ");
        pin = Integer.parseInt(scanner.nextLine());
        customer = bank.getCustomer(pin);
        if (customer == null) {
            System.out.println("PIN is not valid :(");
            return;
        }
        else {
            System.out.println(customer.getAllAccounts());
            System.out.println("Please enter the account number: ");
            int actNum = Integer.parseInt(scanner.nextLine());
            account = customer.getAccount(pin);  //do i need Customer customer??
            if (account == null) {
                System.out.println("Account number invalid :(");
                return;
            }
            else {
                System.out.println("~~~~~~~Account Menu~~~~~~~~\nPlease make a selection:\n1) Make a deposit\n2) Make a withdrawal\n3) See account balance\n4) Close Account\n5) Exit");
                int accountSelect = Integer.parseInt(scanner.nextLine());
                if (accountSelect == 1) {
                    account.deposit();
                } else if (accountSelect == 2) {
                    account.withdraw();
                } else if (accountSelect == 3) {
                    System.out.println(account);
                } else if (accountSelect == 4) {
                    customer.removeAccount(pin, account);
                } else if (accountSelect == 5) {
                    System.out.println("Exiting Account Menu...");
                    return;
                }
                else {
                    System.out.print("Invalid entry :(");
                    return;
                }
            }
        }

    }
    public void createAccount() {
        double deposit;
        Youth customer;
        System.out.println("Are you a new customer? Enter 'yes' or 'no'");
        String newOrReturning = scanner.nextLine();
        if (newOrReturning.equals("yes")) {
            System.out.println("Are you a minor? Enter 'yes' or 'no'");
            String youthOrAdult = scanner.nextLine();
            if (youthOrAdult.equals("yes")) {
                System.out.println("What is your age?");
                Integer age = Integer.parseInt(scanner.nextLine());
            }
            customer = createNewCustomer();
            System.out.println("Enter deposit for new account: ");
            deposit = Double.parseDouble(scanner.nextLine());
        } else if (newOrReturning.equals("no")) {
            System.out.println("Enter your PIN: ");
            int pin = Integer.parseInt(scanner.nextLine());
            customer = bank.getCustomer(pin);
            if (customer == null) {
                System.out.println("PIN not valid :(");
                return;
            } else {
                System.out.println("Enter deposit for new account: ");
                deposit = Double.parseDouble(scanner.nextLine());
            }
        } else {
            System.out.println("Invalid entry :(");
            return;
        }
        Account account = new Account(deposit);
        customer.addAccount(customer.getPin(), account);
        System.out.println("New Account Opened: " + account.getActNum());
    }
    public Youth createNewCustomer() {
        System.out.println("Please enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Please enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Please enter a PIN: ");
        int pin = Integer.parseInt(scanner.nextLine());
        Youth customer = new Youth(firstName, lastName, pin);
        bank.addCustomer(customer);
        return customer;
    }
    public void closeAccounts() {
        System.out.println("Please enter your PIN: ");
        int pin = Integer.parseInt(scanner.nextLine());
        Youth customer = bank.getCustomer(pin);
        if (customer == null) {
            System.out.println("There are no accounts to close.");
            return;
        } else {
            bank.removeCustomer(customer);
            System.out.println("You have been removed from the bank registry.");
        }
    }

}
