package dev.manhnx.bl;

import java.util.List;
import java.util.Scanner;

// import dev.manhnx.dal.OrderDAL;

import dev.manhnx.dal.CafeDAL;
import dev.manhnx.dal.OrderDAL;
import dev.manhnx.persistance.Cafe;
import dev.manhnx.persistance.Order;


public class OrderBL {
    static Scanner sc = new Scanner(System.in);
    private OrderBL obl = new OrderBL();
    public static void showCafeById() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Order_Id: ");
        int id = Integer.parseInt(sc.nextLine());
       List<Order> lst = OrderDAL.getId(id); 
        try {

            System.out.println("|===========================================================================================|");
            System.out.println("|                                   [CSMA] Group-08                                         |");
            System.out.println("|===========================================================================================|");
            System.out.println("|                                       Bill list                                           |");
            System.out.println("|===========================================================================================|");
            System.out.printf("| %-8s | %-6s | %-12s | %-20s | %-9s | %-6s | %-10s | \n", "Order Id", "Acc Id", "Order Status",
                    "Order Date", "Cafe Name", "Amount", "Price");
            System.out.println("|===========================================================================================|");
            for (Order order : lst) {
                System.out.printf("| %-8s | %-6s | %-12s | %-20s | %-9s | %-6s | %-10s | \n", order.getOrderId(), order.getAccId(),
                        order.getOrderStatus(), order.getOrderDate(), order.getCafeName(), order.getAmount(), order.getPrice());
                System.out.println("|===========================================================================================|");


            }
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("erroe" + e);
        }

    }
    private static int input_int() {
        return 0;
    }
    public static void createOrder(){
        int Order_Id;
        String order_Status;
        int Cafe_Id;
        int amount;
        System.out.println(" Enter Table: ");
        Order_Id = input_int();
        System.out.println("Note : ");
        order_Status = sc.nextLine();

    }

    

    public static String yesno() {
        String yn = sc.nextLine();
        if (yn.equalsIgnoreCase("N") || yn.equalsIgnoreCase("Y")) {
            return yn;
        }
        return yn;
    }
}