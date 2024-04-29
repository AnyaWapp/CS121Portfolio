import java.util.Scanner;

public class Account {
    private double balance;
    private int actNum;
    private static int numOfAccounts = 1000;

    public Account(double initialDeposit){
        this.balance = initialDeposit;
        this.actNum = ++numOfAccounts;
    }
    //gs
    public int getActNum() {return actNum;}
    public double getBalance() {return balance;}

    //methods
    public void deposit(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount you would like to deposit: ");
        double addAmount = Double.parseDouble(scanner.nextLine());
        balance += addAmount;
        System.out.println("Amount deposited: $" + addAmount + "  New balance: $" + balance);
    }
    public void withdraw(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter amount to withdraw: ");
        double withdrawAmount = Double.parseDouble(scanner.nextLine());
        if (withdrawAmount > balance){
            System.out.println("Insufficient funds :(");
        }
        else {
            balance -= withdrawAmount;
            System.out.println("Amount withdrawn: $" + withdrawAmount + "  New balance: $" + balance);
        }
    }
    @Override
    public String toString(){
        return String.format("\nAccount number: %d\nBalance: $%.2f\n", actNum, balance);
    }
}
