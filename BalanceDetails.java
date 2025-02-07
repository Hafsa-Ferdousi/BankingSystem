
package bankingapplication;

import java.util.Scanner;

class BalanceDetails extends AccountOperation {

    private Deposit deposit;
    private Withdraw withdraw;

    public BalanceDetails(double initialBalance) {
        super(initialBalance);
        deposit = new Deposit(initialBalance);
        withdraw = new Withdraw(initialBalance);
    }

    // Monthly balance update method with user input
    public void monthly() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nMonthly Transactions:");
        System.out.print("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        deposit.executeOperation(depositAmount);

        // Update balance in Withdraw to reflect changes from Deposit
        withdraw.balance = deposit.getBalance();

        System.out.print("Enter withdrawal amount: ");
        double withdrawAmount = scanner.nextDouble();
        withdraw.executeOperation(withdrawAmount);

        // Update the overall balance
        balance = withdraw.getBalance();
        System.out.println("End of Month Balance: " + balance);
    }

    @Override
    public void executeOperation(double amount) {
        System.out.println("BalanceDetails handles specific operations internally.");
    }
}
