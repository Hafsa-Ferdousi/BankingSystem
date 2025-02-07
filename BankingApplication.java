
package bankingapplication;
import java.util.ArrayList;
import java.util.Scanner;

public class BankingApplication {

   static Scanner scanner;
    static int accountID = 0;
    private static ArrayList<Account> accounts;

    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.flush(); // For clearing the screen

        accounts = new ArrayList<>();
        scanner = new Scanner(System.in);
        Data data = new Data();
        accounts = data.getAccounts();

        System.out.println("\t\t\t\tWelcome To Bank Application\n\n");
        System.out.println("1. Create New Account");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("\nEnter Your Choice : ");
        int i = scanner.nextInt();

        switch (i) {
            case 1:
                new CreateNewAccount(scanner, accountID, accounts, data).addAccount();
                break;
            case 2:
                new Login(scanner, accounts, data);
                break;
        }
    }
}