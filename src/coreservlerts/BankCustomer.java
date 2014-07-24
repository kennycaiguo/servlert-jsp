package coreservlerts;

import java.util.HashMap;

/**
 * Created by zdsoft on 14-7-23.
 */
public class BankCustomer {

    private String id, firstName, lastName;
    private double balance;

    private static HashMap customers;

    static {
        customers = new HashMap();
        customers.put("001", new BankCustomer("id001", "firstName001", "lastName001", -940.99));
        customers.put("002", new BankCustomer("id002", "firstName003", "lastName002", -2940.99));
        customers.put("003", new BankCustomer("id003", "firstName003", "lastName003", -3940.99));

    }

    public static BankCustomer getCustomer(String id){
        return (BankCustomer)customers.get(id);
    }

    public BankCustomer(String id, String firstName, String lastName, double balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }


    public double getBalanceNoSign(){
        return Math.abs(this.balance);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
