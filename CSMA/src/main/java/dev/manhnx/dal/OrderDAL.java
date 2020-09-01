package dev.manhnx.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import dev.manhnx.persistance.Account;
import dev.manhnx.persistance.Cafe;
import dev.manhnx.persistance.Order;

public class OrderDAL {
    public static List<Order> getId(int id) {
        List<Order> lid = new ArrayList<>();
        try (Connection con = ConnectionDB.getConnection()) {
            PreparedStatement pstm = con.prepareStatement("select*from ood where Order_Id=" + id + ";");
            // PreparedStatement pstm = con.prepareStatement("select*from Cafe where Cafe_Id = ?;");
            // pstm.setInt(1, cafe.getCafeId());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                lid.add(getOrderById(rs));
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return lid;
    }

    private static Order  getOrderById(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setOrderId(rs.getInt("Order_Id"));
        order.setAccId(rs.getInt("Acc_Id"));
        order.setOrderStatus(rs.getInt("Order_Status"));
        order.setOrderDate(rs.getDate("Order_Date"));
        order.setCafeName(rs.getString("Cafe_Name"));
        order.setAmount(rs.getInt("Amount"));
        order.setPrice(rs.getDouble("Price"));
        return order;
    }
    public void createOrder( int Acc_Id,int Order, String Order_Status){

    }
    public static void orderAmountByMonth( int year){
        int count = 0;
        System.out.println("+-----------------------------------+");
        System.out.println("|              " + year + "         |");
        System.out.println("+-----------------------------------+");
        System.out.printf("| %-10s | %-15s |\n", "Month", "Amount");
        System.out.println("+-----------------------------------+");
    }
}
