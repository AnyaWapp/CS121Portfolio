import java.util.ArrayList;

public class Bank {
    //List of customers
    private ArrayList<Youth> customerArrayList = new ArrayList<>();

    //methods
    public void addCustomer(Youth customer) {customerArrayList.add(customer);}

    public void removeCustomer(Youth customer) {customerArrayList.remove(customer);}

    public Youth getCustomer(int pin) {
        Youth foundPin = null;
        for(Youth customer : customerArrayList){
            if(customer.getPin() == pin){
                foundPin = customer;
                break;
            }
        }
        return foundPin;
    }
    public StringBuilder getAllCustomerInfo() {
        StringBuilder customerStringBuilder = new StringBuilder();
        for (Youth customer: customerArrayList) {
            customerStringBuilder.append(customer.toString());
        }
        return customerStringBuilder;
    }
}
