package dev.manhnx.bl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

import dev.manhnx.dal.AccountDAL;
import dev.manhnx.dal.ConnectionDB;
import dev.manhnx.persistance.Account;

public class AccountBL {
    private static AccountDAL dal = new AccountDAL();

    public List<Account> getAllAccount() {
        return dal.getAll();
    }

    // public boolean changePass(Account account) throws SQLException {
    // return dal.updateAcc(account);

    // }

    public int login_check(String username, String password) {
        return dal.check_account(username, password);
    }

    // public void getAllAccount() throws SQLException {
    // AccountDAL.getAll();
    // }
    // public boolean createAccount(Account accoount){
    // return dal.insertAccount(accoount);
    // }

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
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("erroe" + e);
        }

    }

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

    public static void update() {
        // AccountBL abl = new AccountBL();
        Scanner sc = new Scanner(System.in);
        if (dal.updateAcc(inputInfo())) {
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

    public static String InputString() {
        Scanner scanner = new Scanner(System.in);
        String x;
        return x = scanner.nextLine();

    }

    public static int InputInt() {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        return y;

    }

    public static Double InputDouble() {
        Scanner scanner = new Scanner(System.in);
        double z = scanner.nextDouble();
        return z;

    }

    public int login(String username, String password) {
        return 0;
    }

	

}