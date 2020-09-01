package dev.manhnx.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import dev.manhnx.persistance.Account;

public class AccountDAL {
    public List<Account> getAll() {
        String sql = "select*from Account";
        List<Account> lst = new ArrayList<Account>();
        try {
            Connection con = ConnectionDB.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                lst.add(getAccount(rs));
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return lst;
    }

    private Account getAccount(ResultSet rs) throws SQLException {
        Account account = new Account();
        account.setAccId(rs.getInt("Acc_Id"));
        account.setUserName(rs.getString("User_Name"));
        account.setPassword(rs.getString("User_Password"));
        account.setEmail(rs.getString("Email"));
        account.setPosition(rs.getInt("Position"));
        account.setAddress(rs.getString("Address"));
        account.setBirthDate(rs.getString("Birth_Date"));
        account.setFullName(rs.getString("Full_Name"));
        account.setPhoneNumber(rs.getString("Phone_Number"));
        account.setGender(rs.getInt("Gender"));
        account.setAccStatus(rs.getInt("Acc_Status"));

        return account;
    }

    public boolean updateAcc(Account account) {
        try {
            String sql = "update Account set User_Password = ? where Acc_Id = ?";
            Connection con = ConnectionDB.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, account.getPassword());
            pstm.setInt(2, account.getAccId());
            pstm.executeUpdate();
        } catch (Exception e) {

        }
        return false;

    }

    public boolean insertAccount(Account account) {
        try {
            String sql = "INSERT INTO Account VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?)";
            Connection con = ConnectionDB.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, account.getAccId());
            pstm.setString(2, account.getFullName());
            pstm.setInt(3, account.getGender());
            pstm.setString(4, account.getAddress());
            pstm.setString(5, account.getPhonNumber());
            pstm.setString(6, account.getEmail());
            pstm.setString(7, account.getBirthDate());
            pstm.setInt(8, account.getAccStatus());
            pstm.setInt(9, account.getPosition());
            pstm.setString(10, account.getUserName());
            pstm.setString(11, account.getPassword());
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("errer" + e);
        }
        return false;

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

    public int check_account(String username, String password) {

        String position = null;
        int id = -1;
        try {
            String strconn =
            "jdbc:mysql://localhost:3306/coffeeshop?user=root&password=123456789";
            Connection conn = DriverManager.getConnection(strconn);
            // Connection conn = ConnectionDB.getConnection();
            Statement start = conn.createStatement();
            ResultSet rs = start.executeQuery(
                    "SELECT Acc_Id,User_Name FROM coffeeshop.account where User_Name = '" + username + "';");
            while (rs.next()) {
                if (username.equals(rs.getString("User_Name"))) {
                    id = rs.getInt("Acc_Id");
                } else {
                    id = -1;
                }

            }
            if (id == -1) {

                return id = -1;
            } else {

                rs = start.executeQuery("SELECT User_Password FROM coffeeshop.account where Acc_Id = '" + id + "';");
                while (rs.next()) {
                    if (password.equals(rs.getString("User_Password"))) {
                        return id;
                    } else {
                        return id = -1;
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Co loi say ra!");
            System.out.println(e);
        }
        return id;
    }
}
