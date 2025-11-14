
package bankingapplication;


import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    
    public Menu(Scanner scanner, Account acc, ArrayList<Account> accounts, Data data){

        int j = 0;

        System.out.println("\n\nWelcome " + acc.getName() + " ! \n");
        BalanceDetails balanceDetails = new BalanceDetails(acc.getBalance());

        do {

        //System.out.print("\033[H\033[2J");
        System.out.flush();
        //System.out.println("\nWelcome " + acc.getName() + " ! \n");
        System.out.println("\n1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Balance");
        System.out.println("4. Monthly Update");
        System.out.println("5. Exit");
        System.out.print("\nEnter Your Choice : ");
        j = scanner.nextInt();
        
        switch(j){
            case 1:
                System.out.print("\nEnter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    balanceDetails.executeOperation(depositAmount); 
                    break;
            case 2 :
                System.out.print("\nEnter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    balanceDetails.executeOperation(-withdrawAmount); 
                    break;
            case 3: // Monthly Balance Update
                    balanceDetails.monthly();
                    break;

                case 4: // Check Balance
                    System.out.println("\nYour Current Balance Is: " + balanceDetails.getBalance());
                    break;

                case 5: // Exit
                    data.saveAccounts(accounts);
                    System.out.println("Exiting... Have a great day!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while ( j != 5);
    }
}



   
   
