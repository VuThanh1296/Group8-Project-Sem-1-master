package dev.manhnx.ui;

import java.util.List;
import java.util.Scanner;

import dev.manhnx.bl.AccountBL;
import dev.manhnx.persistance.Account;

public class AccountUIFunction {
    static AccountBL abl = new AccountBL();
    Scanner sc = new Scanner(System.in);

    public static void showAllAccount() {

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
            // sc.nextLine();
        } catch (Exception e) {
            System.out.println("erroe" + e);
        }

    }

    public static void insertAcc() {
        Scanner sc = new Scanner(System.in);
        try {
            AccountBL abl = new AccountBL();
            abl.insertAccount(inputAcc());
            // dal.insertAccount(inputAcc());
            System.out.println("Insert complete!");
            // sc.nextLine();
        } catch (Exception e) {
            System.out.println("error" + e);
        }

    }

    public static Account inputAcc() {
        Account account = new Account();
        Scanner sc = new Scanner(System.in);
        System.out.print("Acc_Id: ");
        account.setAccId(Integer.parseInt(sc.nextLine()));
        System.out.print("Full_Name: ");
        account.setFullName(sc.nextLine());
        System.out.print("Gender: ");
        account.setGender(Integer.parseInt(sc.nextLine()));
        System.out.print("Address: ");
        account.setAddress(sc.nextLine());
        System.out.print("Phone_Number: ");
        account.setPhoneNumber(sc.nextLine());
        System.out.print("Email: ");
        account.setEmail(sc.nextLine());
        System.out.print("Birth_Date: ");
        account.setBirthDate(sc.nextLine());
        System.out.print("Acc_Status: ");
        account.setAccStatus(Integer.parseInt(sc.nextLine()));
        System.out.print("Position: ");
        account.setPosition(Integer.parseInt(sc.nextLine()));
        System.out.print("User_Name: ");
        account.setUserName(sc.nextLine());
        System.out.print("User_Password: ");
        account.setPassword(sc.nextLine());
        return account;

    }

    public static void update() {
        // AccountBL abl = new AccountBL();
        Scanner sc = new Scanner(System.in);
        if (abl.updateAccount(inputInfo())) {
            System.out.println("update complete");

        } else {
            System.out.println("error");
        }

        sc.nextLine();

    }

    public static Account inputInfo() {
        Account account = new Account();
        Scanner sc = new Scanner(System.in);
        System.out.print("New_Password: ");
        account.setPassword(sc.nextLine());
        System.out.print("Acc_Id: ");
        account.setAccId(sc.nextInt());
        sc.close();
        return account;
    }
}
