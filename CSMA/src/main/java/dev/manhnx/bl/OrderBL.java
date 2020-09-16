package dev.manhnx.bl;

import java.util.List;
import dev.manhnx.dal.OrderDAL;
import dev.manhnx.persistance.Cafe;
import dev.manhnx.persistance.Order;
import dev.manhnx.ui.CafeUIFunction;


public class OrderBL {

    // static Scanner sc = new Scanner(System.in);
    private static OrderDAL orderDAL = new OrderDAL();
    public List<Order> getbyId(int id) {
        return OrderDAL.getId(id);
    }
    // public List<Order> getbyDate(String date) {
    //     return OrderDAL.getDate(date);
    // }
    public static boolean createOrder(List<Cafe> cflist, int Acc_Id,int tableNumber){
        return orderDAL.createOrder(cflist, Acc_Id,tableNumber);
    }
    public Order getCurrentOrder()
    {
        return orderDAL.getCurrentOrderID();
    }

    // private static int input_int() {
    //     int order = Integer.parseInt(sc.nextLine());
    //     return order;
    // }

    
}