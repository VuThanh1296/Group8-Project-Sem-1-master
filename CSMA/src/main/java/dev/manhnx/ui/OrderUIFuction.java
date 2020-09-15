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
        int table;
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
            System.out.println("Enter Table : ");
            table = getIntegerNumber();
            cafe.setTable(table);
            // System.out.println("Note(status) : ");
            // order_Status = sc.nextLine();
            cafesOrder.add(cafe);
            new CafeDAL().updateAmount(amount, Cafe_Id);
            String yn = yesno("Do you want to add cafe to order?(y/n)?");
            if (yn.equalsIgnoreCase("n")) {
                OrderBL.createOrder(cafesOrder, staffID,table);
                break;
            }
        }
        showOrder(cafesOrder, staffID);
        showOrderStaff(cafesOrder, staffID);
    }

    private static Cafe getCafe(int cafeID) {
        List<Cafe> cafes = new CafeBL().getALLCafe();
        Cafe cafeOut = new Cafe();
        for (Cafe cafe : cafes) {
            if (cafe.getCafeId().equals(cafeID)) {
                cafeOut = cafe;
                break;
            }
        }
        return cafeOut;
    }

    public static void inputOrder(List<Cafe> cafes, int staffID) {
        String line = "----------------------------------------------------";
        Order order = obl.getCurrentOrder();
        // System.out.println(line);
        printCenter(line, "Order Detail");
        // System.out.println(line);
        System.out.println("| Order ID : " + order.getOrderId());
        System.out.println("| Staff name : " + getStaffName(staffID));
        System.out.println("| Order Date : " + order.getOrderDate());
        System.out.println("| Order Table : " + order.getTable());
        // System.out.println(line);
        // double intomoney = 0;
        for (Cafe cafe : cafes) {
            System.out.println("| Product Name : " + cafe.getCafeName());
            System.out.println("| Product amount : " + cafe.getAmount());
            System.out.println("| Product price : " + cafe.getCafePrice());
            // intomoney += cafe.getAmount() * cafe.getCafePrice();
        }
        // System.out.println("| Total bill : " +intomoney);
        System.out.println(line);
        sc.nextLine();
    }

    static String getStaffName(int staffID) {
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

    public static void showOrder(List<Cafe> cafes, int staffID){
        double intomoney  =0;
       double totalbill = 0;
        // String line = "----------------------------------------------------";
        Order order = obl.getCurrentOrder();
        // System.out.println(line);
        // printCenter(line, "Order Detail");
        System.out.println("\n");
    System.out.println("|========================================================================|");
    System.out.println("|                               Coffee Shop                              |");
    System.out.println("|========================================================================|");
    System.out.println("|                                Bill Pay                                |");
    System.out.println("|========================================================================|");
    System.out.printf("| Order Id: %-12s                Staff name: %-20s |\n", order.getOrderId(),getStaffName(staffID));
    System.out.printf("| Date : %-12s                   Table : %-20s     |\n",order.getOrderDate(),order.getTable());
    System.out.println("|========================================================================|");
    System.out.printf("| %-15s | %-6s | %-20s | %-20s |\n",  
             "Cafe Name", "Amount", "Price"," into money");
    System.out.println("|========================================================================|");
    for (Cafe cafe : cafes) {
        // System.out.println("| intomoney : " + intomoney);
      intomoney  = cafe.getAmount() * cafe.getCafePrice();
      totalbill = totalbill + intomoney;
        System.out.printf("| %-15s | %-6s | %-20s | %-20s |\n",  cafe.getCafeName(), cafe.getAmount(), cafe.getCafePrice(),intomoney);
        System.out.println("|------------------------------------------------------------------------|");
        // System.out.println("|=====================================================================|");
        
    }
    // System.out.println("|========================================================================|");
    System.out.printf("|ToTal Bill :                                        %-20s|\n",totalbill);
    System.out.println("|========================================================================|");
    System.out.println("|                     Thanks you, see you again                          |");
    System.out.println("|========================================================================|");
}
public static void showOrderStaff(List<Cafe> cafes, int staffID){
    Order order = obl.getCurrentOrder();
    System.out.println("\n");
    System.out.println("|========================================================================|");
    System.out.println("|                               Coffee Shop                              |");
    System.out.println("|========================================================================|");
    System.out.println("|                                Bill Pay                                |");
    System.out.println("|========================================================================|");
    System.out.printf("| Order Id: %-12s                Staff name: %-20s |\n", order.getOrderId(),getStaffName(staffID));
    System.out.printf("| Date : %-12s                   Table : %-20s     |\n",order.getOrderDate(),order.getTable());
    System.out.println("|========================================================================|");
    System.out.printf("| %-34s | %-33s |\n",  "Cafe Name", "Amount");
    System.out.println("|========================================================================|");
    for (Cafe cafe : cafes) {
        System.out.printf("| %-34s | %-33s |\n",  cafe.getCafeName(), cafe.getAmount());
        System.out.println("|------------------------------------------------------------------------|");
    }
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
