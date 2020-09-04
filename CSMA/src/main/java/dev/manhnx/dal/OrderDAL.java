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

import dev.manhnx.persistance.Cafe;
import dev.manhnx.persistance.Order;

public class OrderDAL {
    public  List<Order> getId(int id) {
        List<Order> lid = new ArrayList<>();
        try (Connection con = ConnectionDB.getConnection()) {
            PreparedStatement pstm = con.prepareStatement("select*from ood where Order_Id=" + id + ";");
            // PreparedStatement pstm = con.prepareStatement("select*from Cafe where Cafe_Id
            // = ?;");
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

    public  Order getOrderById(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setOrderId(rs.getInt("Order_Id"));
        order.setAccId(rs.getInt("Acc_Id"));
        order.setOrderStatus(rs.getInt("Order_Status"));
        order.setOrderDate(rs.getString("Order_Date"));
        order.setCafeName(rs.getString("Cafe_Name"));
        order.setAmount(rs.getInt("Amount"));
        order.setPrice(rs.getDouble("Price"));
        return order;
    }

    public  void createOrder(List<Cafe> cflist, int Acc_Id) {

        String sqlCrateOrder = "INSERT INTO `Order_drinks` (`Acc_id`,`Order_status`,`Order_Date`) VALUES ("+Acc_Id+","+2+","+LocalDate.now().toString()+")";
        try (Connection con = ConnectionDB.getConnection();) {
            CallableStatement cs = con.prepareCall(sqlCrateOrder);

            cs.execute();
            for (Cafe cafe : cflist) {
                
                String  sqlCrateOrderDetail = "INSERT INTO order_Details(order_id,cafe_id,amount,price) VALUES()";
                cs = con.prepareCall(sqlCrateOrderDetail);
                cs.execute();
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error!");
            System.out.println(e.toString());
        }

    }
public   Order getCurrentOrderID()
{
    Order order = new Order();
    String sql = "Select *  from coffeeshop.order_drinks order by order_id desc limit 1;";
    try(Connection con = ConnectionDB.getConnection();
    CallableStatement csm =con.prepareCall(sql)){
    ResultSet rs = csm.executeQuery();
    if(rs.next())
    {
       order = getOrderById(rs);

    }
    } catch (Exception e) {
        //TODO: handle exception
    }
    return order;
}

    public static void orderAmountByMonth(int year) {
        int count = 0;
        System.out.println("+-----------------------------------+");
        System.out.println("|              " + year + "         |");
        System.out.println("+-----------------------------------+");
        System.out.printf("| %-10s | %-15s |\n", "Month", "Amount");
        System.out.println("+-----------------------------------+");
    }
}
