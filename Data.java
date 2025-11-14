package bankingapplication;

import java.io.*;
import java.util.ArrayList;

public class Data {

    File file;

    public Data() {

        // Create folder if not exists
        File folder = new File("Files");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Create file with extension
        file = new File("Files/Data.txt");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Account> getAccounts() {

        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;

            while ((s = br.readLine()) != null) {
                text.append(s).append("\n");
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Account> accounts = new ArrayList<>();

        // split properly
        String[] blocks = text.toString().split("NEW_ACCOUNT");

        for (String block : blocks) {

            block = block.trim();

            if (block.isEmpty()) continue;

            String[] arr = block.split("A");

            Account a = new Account();
            a.setName(arr[0]);
            a.setAccountNo(Integer.parseInt(arr[1]));
            a.setBalance(Double.parseDouble(arr[2]));
            a.setPassword(Integer.parseInt(arr[3]));

            accounts.add(a);
        }

        return accounts;
    }

    public void saveAccounts(ArrayList<Account> accounts) {

        StringBuilder text = new StringBuilder();

        for (Account a : accounts) {
            text.append("NEW_ACCOUNT").append("\n");
            text.append(a.getName()).append("A");
            text.append(a.getAccountNo()).append("A");
            text.append(a.getBalance()).append("A");
            text.append(a.getPassword()).append("\n");
        }

        try {
            PrintWriter pw = new PrintWriter(file);
            pw.print(text.toString());
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

