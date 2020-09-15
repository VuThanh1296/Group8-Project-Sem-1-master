package dev.manhnx.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import dev.manhnx.persistance.Cafe;
import dev.manhnx.persistance.Order;

public class OrderDAL {
    public static List<Order> getId(int id) {
        List<Order> lid = new ArrayList<>();
        try (Connection con = ConnectionDB.getConnection()) {
            PreparedStatement pstm = con.prepareStatement("select*from ood  where Order_Id=" + id + ";");
            // PreparedStatement pstm = con.prepareStatement("select*from Cafe where Cafe_Id
            // = ?;");
            // pstm.setInt(1, cafe.getCafeId());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                lid.add(getOrder(rs));
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return lid;
    }

    public static Order getOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setOrderId(rs.getInt("Order_Id"));
        order.setAccId(rs.getInt("Acc_Id"));
        order.setTable(rs.getInt("Order_Table"));
        order.setOrderDate(rs.getString("Order_Date"));
        // order.setAccId(rs.getInt("Acc_Id"));
        // order.setCafeName(rs.getString("cafe_Name"));
        // order.setAmount(rs.getInt("amount"));
        // order.setPrice(rs.getDouble("price"));
        // order.setOrderDate(rs.getString("Order_Date"));
        return order;
    }

    
    public boolean createOrder(List<Cafe> cflist, int Acc_Id,int tableNumber) {

        String sqlCrateOrder = "{call insertOrder(?,?,?)};";
        try (Connection con = ConnectionDB.getConnection();) {
            CallableStatement cs = con.prepareCall(sqlCrateOrder);
            cs.setInt(1, Acc_Id);
            cs.setInt(2,tableNumber);
            String date = LocalDate.now().toString();
            cs.setString(3,date);
            cs.execute();
            String sqlCrateOrderDetail = "{call insertOrderDetail(?,?,?,?)};";
            for (Cafe cafe : cflist) {
                cs= con.prepareCall(sqlCrateOrderDetail);
                Order order = getCurrentOrderID();
                cs.setInt(1, order.getOrderId());
                cs.setInt(2, cafe.getCafeId());
                cs.setInt(3, cafe.getAmount());
                cs.setDouble(4, cafe.getCafePrice());
                cs.execute();
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error!");
            System.out.println(e.toString());
        }
        return false;

    }

    public Order getCurrentOrderID() {
        Order order = new Order();
        String sql = "Select *  from coffeeshop.orders order by order_id desc limit 1;";
        try (Connection con = ConnectionDB.getConnection();){
            CallableStatement csm = con.prepareCall(sql);
            ResultSet rs = csm.executeQuery();
            if (rs.next()) {
                order = getOrder(rs);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return order;
    }
    // public static void updateOrder(int order_id, int Cafe_Id, int Amount)
    // {
        
    //     String sql = "update OrderDetails set Cafe_Id =? ,Amount= ? where Order_ID =? ";
    //     try (Connection con = ConnectionDB.getConnection();
    //     CallableStatement cs = con.prepareCall(sql)){
    //         cs.setInt(1, order_id);
    //         cs.setInt(2, Cafe_Id);
    //         cs.setInt(3, Amount);
    //         cs.execute();
    //         // ResultSet rs = csm.executeQuery();

    //     } catch (Exception e) {
    //         //TODO: handle exception
    //         System.out.println("Error!");
    //         System.out.println(e.toString());
    //     }
    // }

//     public static void orderAmountByMonth(int year) {
//         int count = 0;
//         System.out.println("+-----------------------------------+");
//         System.out.println("|              " + year + "         |");
//         System.out.println("+-----------------------------------+");
//         System.out.printf("| %-10s | %-15s |\n", "Month", "Amount");
//         System.out.println("+-----------------------------------+");
//     }
}
