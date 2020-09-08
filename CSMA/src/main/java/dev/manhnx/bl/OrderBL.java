package dev.manhnx.bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.manhnx.dal.AccountDAL;
import dev.manhnx.dal.CafeDAL;

// import dev.manhnx.dal.OrderDAL;

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
    public static boolean createOrder(List<Cafe> cflist, int Acc_Id){
        return orderDAL.createOrder(cflist, Acc_Id);
    }
    

    // private static int input_int() {
    //     int order = Integer.parseInt(sc.nextLine());
    //     return order;
    // }

    
}