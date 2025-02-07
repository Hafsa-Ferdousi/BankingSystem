
package bankingapplication;

import java.util.Scanner;
abstract class AccountOperation {
    protected double balance;

    public AccountOperation(double initialBalance) {
        this.balance = initialBalance;
    }

    public abstract void executeOperation(double amount);

    public double getBalance() {
        return balance;
    }
}