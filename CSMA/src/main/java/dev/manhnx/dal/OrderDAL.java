package dev.manhnx.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.CSS;

import com.mysql.cj.xdevapi.Statement;

import dev.manhnx.bl.OrderBL;
import dev.manhnx.persistance.Cafe;
import dev.manhnx.persistance.Order;

public class OrderDAL {
    public List<Order> getId(int id) {
        List<Order> lid = new ArrayList<>();
        try (Connection con = ConnectionDB.getConnection()) {
            PreparedStatement pstm = con.prepareStatement("select*from ood where Order_Id=" + id + ";");
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

    public Order getOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setOrderId(rs.getInt("Order_Id"));
        order.setAccId(rs.getInt("Acc_Id"));
        order.setOrderStatus(rs.getString("Order_Status"));
        order.setOrderDate(rs.getString("Order_Date"));
        return order;
    }

    
    public void createOrder(List<Cafe> cflist, int Acc_Id) {

        String sqlCrateOrder = "{call insertOrder(?,?,?)};";
        try (Connection con = ConnectionDB.getConnection();) {
            CallableStatement cs = con.prepareCall(sqlCrateOrder);
            cs.setInt(1, Acc_Id);
            cs.setInt(2,2);
            String date = LocalDate.now().toString();
            cs.setString(3,date);
            cs.execute();
            for (Cafe cafe : cflist) {
                String sqlCrateOrderDetail = "{call insertOrderDetail(?,?,?,?)};";
                cs = con.prepareCall(sqlCrateOrderDetail);
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

    }

    public Order getCurrentOrderID() {
        Order order = new Order();
        String sql = "Select *  from coffeeshop.order_drinks order by order_id desc limit 1;";
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
    public static void updateOrder(int order_id, int Cafe_Id, int Amount)
    {
        
        String sql = "update Order_Details set Cafe_Id =? ,Amount= ? where Order_ID =? ";
        try (Connection con = ConnectionDB.getConnection();
        CallableStatement cs = con.prepareCall(sql)){
            cs.setInt(1, order_id);
            cs.setInt(2, Cafe_Id);
            cs.setInt(3, Amount);
            cs.execute();
            // ResultSet rs = csm.executeQuery();

        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error!");
            System.out.println(e.toString());
        }
    }

//     public static void orderAmountByMonth(int year) {
//         int count = 0;
//         System.out.println("+-----------------------------------+");
//         System.out.println("|              " + year + "         |");
//         System.out.println("+-----------------------------------+");
//         System.out.printf("| %-10s | %-15s |\n", "Month", "Amount");
//         System.out.println("+-----------------------------------+");
//     }
}
