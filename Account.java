
package bankingapplication;


public class Account {

    private String name;
    private int accountNo;
    private double balance;
    private int password;

    public Account(String name, int accountNo, double balance, int password) { // Constructor
        this.name = name;
        this.accountNo = accountNo;
        this.balance = balance;
        this.password = password;
    }

    public Account() {} // Default Constructor

    // Mutator and Accessor methods
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getPassword() {
        return password;
    }
}