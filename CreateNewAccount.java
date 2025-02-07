
package bankingapplication;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateNewAccount implements Manager{
private Scanner scanner;
    private int accountID;
    private ArrayList<Account> accounts;
    private Data data;

    // Constructor for CreateNewAccount
    public CreateNewAccount(Scanner scanner, int accountID, ArrayList<Account> accounts, Data data) {
        this.scanner = scanner;
        this.accountID = accountID;
        this.accounts = accounts;
        this.data = data;
    }
    @Override
    public void addAccount() {
        System.out.println("Enter your name : ");
        String gv = scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter balance : ");
        double balance = scanner.nextDouble();
        System.out.println("Enter Password : ");
        int password = scanner.nextInt();
        System.out.println("Confirm Password : ");
        int passcode = scanner.nextInt();

        if (passcode != password){
            System.out.println("Password is not matching ! ");
            return;
        }
        
        int accountNo = 1000 + accountID;
        accountID += 1;//generating new account no for each user

        Account acc = new Account(name, accountNo, balance, password);
        accounts.add(acc);//adding the account
        System.out.println("Your Account No is : " + accountNo);
        new Menu(scanner,acc, accounts, data);
    }
}
 
    

