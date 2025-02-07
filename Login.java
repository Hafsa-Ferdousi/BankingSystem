
package bankingapplication;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
      public Login(Scanner scanner, ArrayList<Account> accounts, Data data){
        Account account = new Account();
        boolean exists = false;

        System.out.print("\033[H\033[2J");
        System.out.flush();//for clearing the screen
        
        System.out.print("\nEnter Account No : ");
        int accountNo = scanner.nextInt();
        System.out.print("\nEnter Password : ");
        int password = scanner.nextInt();
        for (Account acc : accounts){
            if (acc.getAccountNo() == accountNo && acc.getPassword() == password){
                exists = true;
                account = acc;
            }
        }
        if (exists){
            new Menu(scanner,account, accounts, data);
        }
        else {
            System.out.println("Account Doesn't Exist !");
        }
    }
}
