
package bankingapplication;




import java.util.Scanner;

public class Withdraw extends AccountOperation {

    public Withdraw(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void executeOperation(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("\nAmount Withdrawn Successfully!");
        }
    }
}
