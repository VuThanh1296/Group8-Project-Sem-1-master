package dev.manhnx.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.manhnx.bl.CafeBL;
import dev.manhnx.bl.OrderBL;
import dev.manhnx.dal.AccountDAL;
import dev.manhnx.dal.CafeDAL;
import dev.manhnx.persistance.Cafe;
import dev.manhnx.persistance.Order;

public class OrderUIFuction {
    static Scanner sc = new Scanner(System.in);
    static OrderBL obl = new OrderBL();

    public static void showOrderById() {

        System.out.print("Enter Order_Id: ");

        int id = Integer.parseInt(sc.nextLine());
        List<Order> lst = obl.getbyId(id);
        try {

            System.out.println(
                    "|===========================================================================================|");
            System.out.println(
                    "|                                   [CSMA] Group-08                                         |");
            System.out.println(
                    "|===========================================================================================|");
            System.out.println(
                    "|                                       Bill list                                           |");
            System.out.println(
                    "|===========================================================================================|");
            System.out.printf("| %-8s | %-6s | %-12s | %-20s | %-9s | %-6s | %-10s | \n", "Order Id", "Acc Id",
                    "Order Status", "Order Date", "Cafe Name", "Amount", "Price");
            System.out.println(
                    "|===========================================================================================|");
            for (Order order : lst) {
                System.out.printf("| %-8s | %-6s | %-12s | %-20s | %-9s | %-6s | %-10s | \n", order.getOrderId(),
                        order.getAccId(), order.getOrderStatus(), order.getOrderDate(), order.getCafeName(),
                        order.getAmount(), order.getPrice());
                System.out.println(
                        "|===========================================================================================|");

            }
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("erroe" + e);
        }

    }
    public static void createOrder(int staffID) {

        // int Order_Id;
        String order_Status;
        int Cafe_Id;
        int amount;
        // System.out.println(" Enter Table(Order_id): ");
        // Order_Id = input_int();
       
        boolean isContinueAddCafeToOrder = true;
        List<Cafe> cafesOrder = new ArrayList<>(); 
        while (isContinueAddCafeToOrder) {
            
            Cafe cafe = new Cafe();
            CafeUIFunction.showAllCafe();
            System.out.print("Enter cafe id : ");
            Cafe_Id = getIntegerNumber();
            cafe = getCafe(Cafe_Id);
            System.out.println("Enter amount : ");
            amount = getIntegerNumber();
            cafe.setAmount(amount);
            System.out.println("Note(status) : ");
            order_Status = sc.nextLine();
            cafesOrder.add(cafe);
            new CafeDAL().updateAmount(amount, Cafe_Id);
            String yn = yesno("Do you want to add cafe to order?(y/n)?");
            if (yn.equalsIgnoreCase("n")) {
                OrderBL.createOrder(cafesOrder, staffID);
                break;
            }
        }
        showOrder(cafesOrder,staffID);
    }
    private static Cafe getCafe(int cafeID)
    {   List<Cafe> cafes = new CafeBL().getALLCafe();
        Cafe cafeOut = new Cafe();
        for (Cafe cafe : cafes) {
            if(cafe.getCafeId().equals(cafeID))
            {
                cafeOut = cafe;
                break;
            }
        }
        return cafeOut;
    }
    public static void showOrder(List<Cafe> cafes, int staffID) {
        String line = "----------------------------------------------------";
        // Order order = orderDAL.getCurrentOrderID();
        // System.out.println(line);
        Order order = new Order();
        printCenter(line, "Order Detail");
        System.out.println(line);
        System.out.println("| Order ID : " + order.getOrderId());
        System.out.println("| Staff name : " + getStaffName(staffID));
        System.out.println("| Order Date : "+order.getOrderDate());
        System.out.println(line);
        double totalBill = 0;
        for (Cafe cafe : cafes) {
        System.out.println("| Product Name : "+cafe.getCafeName());
        System.out.println("| Product amount : "+cafe.getAmount());
        System.out.println("| Product price : "+cafe.getCafePrice());
        totalBill+= cafe.getAmount() * cafe.getCafePrice();
    }
        System.out.println("| Total bill : " + totalBill);
        System.out.println(line);
        sc.nextLine();
    }
    static String getStaffName(int staffID)
    {
        return new AccountDAL().getUserName(staffID);
    }
    static void printCenter(String line, String content) {
        int sizeOfLine = line.length();
        int midPositionOfLine = sizeOfLine / 2;
        int midPositionOfContent = content.length() / 2;
        int startPrintPoint = midPositionOfLine - midPositionOfContent;
        int restOfLine = sizeOfLine - content.length() - 4;
        String contentOut = "| %-" + startPrintPoint + "s %-" + restOfLine + "s |\n";
        System.out.printf(contentOut, startPrintPoint, "");
    }

   

    static int getIntegerNumber() {
        int number = 0;
        boolean enterIsNumber = true;
        while (enterIsNumber)
            try {
                number = Integer.parseInt(sc.nextLine());
                enterIsNumber = false;
            } catch (Exception e) {
                System.out.println("Data type input is wrong!");
            }
        return number;
    }
    // public static void updateOrder(int Order_id,int Cafe_Id,int Amount) {
    //        Order order = new Order();
    //        OrderBL.showOrder(Order_id,Cafe_Id,Amount);
            
    //     }
    // }
    // public static Order inputUpdateOrder() {
    //     Order order = new Order();
    //     Scanner sc = new Scanner(System.in)
    //     System.out.println("");
    //     return order;
    // }

    private static void showOrder(int order_id, int cafe_Id, int amount) {
    }

    public static String yesno(String content) {
        boolean isValidInput = true;
        String yn = "";
        while (isValidInput) {
            System.out.print(content);
            yn = sc.nextLine();
            if (yn.equalsIgnoreCase("N") || yn.equalsIgnoreCase("Y")) {
                break;
            }
            System.out.println("Input is wrong!");
        }
        return yn;
    }
}
