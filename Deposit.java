
package bankingapplication;

// Deposit class inheriting from AccountOperation


import java.util.Scanner;

public class Deposit extends AccountOperation {

    public Deposit(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void executeOperation(double amount) {
        balance += amount;
        System.out.println("\nAmount Deposited Successfully!");
    }
}

