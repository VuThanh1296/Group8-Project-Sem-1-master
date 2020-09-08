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

    public boolean insertAccount(Account account) throws SQLException {
        
        return dal.insertAccount(account);
    }
    public boolean updateAccount(Account accoount){
    return dal.updateAcc(accoount);
    }

    

    

    

    // public static String InputString() {
    //     Scanner scanner = new Scanner(System.in);
    //     String x;
    //     return x = scanner.nextLine();

    // }

    // public static int InputInt() {
    //     Scanner scanner = new Scanner(System.in);
    //     int y = scanner.nextInt();
    //     return y;

    // }

    // public static Double InputDouble() {
    //     Scanner scanner = new Scanner(System.in);
    //     double z = scanner.nextDouble();
    //     return z;

    // }

    public int login(String username, String password) {
        return 0;
    }

	

}