package dev.manhnx.ui;

import java.util.List;
import java.util.Scanner;

import dev.manhnx.bl.AccountBL;
import dev.manhnx.persistance.Account;

public class showAcc {
    public static void showAllAccount() {
        AccountBL abl = new AccountBL();
        Scanner sc = new Scanner(System.in);
        List<Account> lst = new AccountBL().getAllAccount();
        try {

            System.out.println(
                    "================================================================================================================================================================================================");
            ;
            System.out.println("Group-08");
            System.out.println(
                    "================================================================================================================================================================================================");
            System.out.println("Account list");
            System.out.println(
                    "================================================================================================================================================================================================");
            System.out.printf(
                    "| %-5s | %-20s | %-6s | %-30s | %-11s | %-30s | %-20s | %-6s | %-10s | %-10s | %-10s | \n",
                    "AccId", "Fullname", "Gender", "Address", "Phone", "Email", "Birthdate", "Status", "Position",
                    "Username", "Password");
            System.out.println(
                    "================================================================================================================================================================================================");
            for (Account account : lst) {
                System.out.printf(
                        "| %-5s | %-20s | %-6s | %-30s | %-11s | %-30s | %-20s | %-6s | %-10s | %-10s | %-10s |  \n",
                        account.getAccId(), account.getFullName(), account.getGender(), account.getAddress(),
                        account.getPhonNumber(), account.getEmail(), account.getBirthDate(), account.getAccStatus(),
                        account.getPosition(), account.getUserName(), account.getPassword());
                System.out.println(
                        "=================================================================================================================================================================================================");

            }
            System.out.println("Press enter to back!");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("erroe" + e);
        }

    }
}
