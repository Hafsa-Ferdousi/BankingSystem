
package bankingapplication;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class Data {

  
    File file;
    
    public Data(){

        file = new File("Files/Data");
        if (!file.exists()){
            try {//Exception Handling
                file.createNewFile();
            } catch (Exception e){
                e.printStackTrace();
            };
        }
    }

    public ArrayList<Account> getAccounts(){

        String text = "";

        //Exception Handling

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null){
                text = text + s;
            }
            br.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        ArrayList<Account> accounts = new ArrayList<>();
        String array1[] = text.split("New Account");

        //getting the account's information
        
        for (String v : array1){
            if (!v.equals("")){
            String[] array2 = v.split("A");
            Account a = new Account();
            a.setName(array2[0]);
            a.setAccountNo(Integer.parseInt(array2[1]));
            a.setBalance(Double.parseDouble(array2[2]));
            a.setPassword(Integer.parseInt(array2[3]));
            accounts.add(a);
            }
        }
        return accounts;
    }
        
    public void saveAccounts(ArrayList<Account> accounts){
        
        String text = "";
        for (Account a : accounts){
            StringBuilder sb = new StringBuilder();
            sb.append(a.getName()).append("A");
            sb.append(String.valueOf(a.getAccountNo())).append("A");
            sb.append(String.valueOf(a.getBalance())).append("A");
            sb.append(String.valueOf(a.getPassword())).append("A");
            text = text + sb.toString();
        }
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.print(text);
            pw.close();
        } catch ( FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
