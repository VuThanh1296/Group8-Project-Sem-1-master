package dev.manhnx.ui;

import java.util.Scanner;

import dev.manhnx.bl.AccountBL;

public class InsertAcc {
    static AccountBL accountBL = new AccountBL();
    public static void insertAcc() {
        Scanner sc = new Scanner(System.in);
        try {
            AccountBL abl = new AccountBL();
            // abl.createAccount(inputAcc());
            dal.insertAccount(inputAcc());
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("error" + e);
        }

    }

    public static Account inputAcc() {
        Account account = new Account();

        System.out.print("Acc_Id: ");
        account.setAccId(InputInt());
        System.out.print("Full_Name: ");
        account.setFullName(InputString());
        System.out.print("Gender: ");
        account.setGender(InputInt());
        System.out.print("Address: ");
        account.setAddress(InputString());
        System.out.print("Phone_Number: ");
        account.setPhoneNumber(InputString());
        System.out.print("Email: ");
        account.setEmail(InputString());
        System.out.print("Birth_Date: ");
        account.setBirthDate(InputString());
        System.out.print("Acc_Status: ");
        account.setAccStatus(InputInt());
        System.out.print("Position: ");
        account.setPosition(InputInt());
        System.out.print("User_Name: ");
        account.setUserName(InputString());
        System.out.print("User_Password: ");
        account.setPassword(InputString());
        return account;

    }
}
