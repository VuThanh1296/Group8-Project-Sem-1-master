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

public class OrderBL {

    static Scanner sc = new Scanner(System.in);
    private static OrderDAL orderDAL = new OrderDAL();

    public static void showCafeById() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Order_Id: ");
        int id = Integer.parseInt(sc.nextLine());
        List<Order> lst = orderDAL.getId(id);
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

    private static int input_int() {
        int order = Integer.parseInt(sc.nextLine());
        return order;
    }

    public static void createOrder(int staffID) {
        int Order_Id;
        String order_Status;
        int Cafe_Id;
        int amount;
        System.out.println(" Enter Table(Order_id): ");
        Order_Id = input_int();
        System.out.println("Note(status) : ");
        order_Status = sc.nextLine();
        boolean isContinueAddCafeToOrder = true;
        List<Cafe> cafesOrder = new ArrayList<>(); 
        while (isContinueAddCafeToOrder) {
            List<Cafe> cafes = new CafeBL().getALLCafe();
            Cafe cafe = new Cafe();
            CafeBL.showAllCafe(cafes);
            System.out.print("Enter cafe id : ");
            Cafe_Id = getIntegerNumber();
            cafe.setCafeId(Cafe_Id);
            System.out.println("Enter amount : ");
            amount = getIntegerNumber();
            cafe.setAmount(amount);
            cafesOrder.add(cafe);
            new CafeDAL().updateAmount(amount, Cafe_Id);
            String yn = yesno("Do you want to add cafe to order?(y/n)?");
            if (yn.equalsIgnoreCase("n")) {
                orderDAL.createOrder(cafesOrder, staffID);
                System.out.println(orderDAL.getCurrentOrderID().getOrderId());
                break;
            }
        }
    
        showOrder(cafesOrder,orderDAL.getCurrentOrderID().getOrderId(),staffID);

    }
    
    public static void showOrder(List<Cafe> cafes,int orderID, int staffID) {
        String line = "----------------------------------------------------";
        Order order = orderDAL.getCurrentOrderID();
        System.out.println(line);
        printCenter(line, "Order Detail");
        System.out.println(line);
        System.out.println("| Order ID : " + orderID);
        System.out.println("| Staff name : " + getStaffName(staffID));
        System.out.println("| Order Date : "+order.getOrderDate());
        System.out.println(line);
        for (Cafe cafe : cafes) {
        System.out.println("| Product Name : "+cafe.getCafeName());
        System.out.println("| Product amount : "+cafe.getAmount());
        System.out.println("| Product price : "+cafe.getCafePrice());
        }
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

    static Cafe getCafe(List<Cafe> cafes, Integer Cafe_Id) {
        Cafe cf = null;
        for (Cafe cafe : cafes) {
            if (Cafe_Id.equals(cafe.getCafeId())) {
                cf = cafe;
                break;
            }
        }
        return cf;
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