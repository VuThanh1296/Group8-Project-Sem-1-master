package dev.manhnx.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import com.mysql.cj.jdbc.CallableStatement;

import dev.manhnx.dal.CafeDAL;
import dev.manhnx.dal.OrderDAL;
import dev.manhnx.persistance.Cafe;
import dev.manhnx.ui.AccountUI;

public class CafeBL {
    private static CafeDAL cafeDAL = new CafeDAL();
    // private static String productname;
    // static CallableStatement callableStatement = null;
    // static AccountUI accountUI;
    public List<Cafe> getALLCafe() {
        return cafeDAL.getALL();
    }

    public boolean addCafe(Cafe cafe) {
        return cafeDAL.insertCafe(cafe);
    }

    // public List<Cafe> getbyId() {
    // return cafeDAL.getId();
    // }

    public static void insertCafe() {
        CafeBL cbl = new CafeBL();
        System.out.println("Insert new Cafe:");
        try {
            cbl.addCafe(inputCafe());
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

    public static Cafe inputCafe() {
        Cafe cafe = new Cafe();
        System.out.print("Cafe Id: ");
        cafe.setCafeId(InputInt());
        System.out.print("Cafe Name: ");
        cafe.setCafeName(InputString());
        System.out.print("Cafe Price:");
        cafe.setCafePrice(InputDouble());
        System.out.print("Available: : ");
        cafe.setCafeAvailable(InputInt());
        return cafe;
    }

    public static void updateCafe() {
        // AccountBL abl = new AccountBL();
        Scanner sc = new Scanner(System.in);
        if (cafeDAL.updateCafe(inputInfo())) {
            System.out.println("update complete");

        } else {
            System.out.println("error");
        }

        sc.nextLine();

    }

    public static Cafe inputInfo() {
        Cafe cafe = new Cafe();
        Scanner sc = new Scanner(System.in);
        System.out.print("Cafe_Id: ");
        cafe.setCafeId(sc.nextInt());
        System.out.print("New Cafe_Id: ");
        cafe.setCafeId(sc.nextInt());
        System.out.print("New Cafe_Name: ");
        cafe.setCafeName(sc.nextLine());
        System.out.print("New Cafe_Price: ");
        cafe.setCafeAvailable(sc.nextInt());
        System.out.print("New Cafe_Available: ");
        cafe.setCafeAvailable(sc.nextInt());
        System.out.print("New Cafe_Status: ");
        cafe.setCafeStatus(sc.nextInt());
        sc.close();
        return cafe;
    }

    public static void showCafeById() {

        CafeBL cbl = new CafeBL();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = Integer.parseInt(sc.nextLine());
        List<Cafe> lst = CafeDAL.getId(id);
        try {

            System.out.println("|==============================================================================|");
            System.out.println("|                            [CSMA] Group-08                                   |");
            System.out.println("|==============================================================================|");
            System.out.println("|                                Cafe list                                     |");
            System.out.println("|==============================================================================|");
            System.out.printf("| %-7s | %-20s | %-10s | %-15s | %-12s | \n", "Cafe Id", "Cafe Name", "Cafe Price",
                    "Cafe Available", "Cafe Status");
            System.out.println("|==============================================================================|");
            for (Cafe cafe : lst) {
                System.out.printf("| %-7s | %-20s | %-10s | %-15s | %-12s | \n", cafe.getCafeId(), cafe.getCafeName(),
                        cafe.getCafePrice(), cafe.getCafeAvailable(), cafe.getCafeStatus());
                System.out.println("|==============================================================================|");


            }
            System.out.println("nhap Enter de tiep tuc");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("erroe" + e);
        }

    }

    public static void showAllCafe() {
        CafeBL cbl = new CafeBL();
        Scanner sc = new Scanner(System.in);
        List<Cafe> lst = new CafeDAL().getALL();
        try {

            System.out.println("|==============================================================================|");
            System.out.println("|                            [CSMA] Group-08                                   |");
            System.out.println("|==============================================================================|");
            System.out.println("|                                Cafe list                                     |");
            System.out.println("|==============================================================================|");
            System.out.printf("| %-7s | %-20s | %-10s | %-15s | %-12s | \n", "Cafe Id", "Cafe Name", "Cafe Price",
                    "Cafe Available", "Cafe Status");
            System.out.println("|==============================================================================|");
            for (Cafe cafe : lst) {
                System.out.printf("| %-7s | %-20s | %-10s | %-15s | %-12s | \n", cafe.getCafeId(), cafe.getCafeName(),
                        cafe.getCafePrice(), cafe.getCafeAvailable(), cafe.getCafeStatus());
                System.out.println("|==============================================================================|");

            }
            System.out.println("nhấn phím bất kỳ để quay lại!");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("erroe" + e);
        }

    }

    public static String InputString() {
        Scanner scanner = new Scanner(System.in);
        String x;
        return x = scanner.nextLine();

    }

    public static int InputInt() {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        return y;

    }

    public static Double InputDouble() {
        Scanner scanner = new Scanner(System.in);
        double z = scanner.nextDouble();
        return z;

    }
    

    public static void showCafeByName() {

        CafeBL cfbl = new CafeBL();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        List<Cafe> lis = CafeDAL.getName(name);
        
        try {

            System.out.println("|==============================================================================|");
            System.out.println("|                            [CSMA] Group-08                                   |");
            System.out.println("|==============================================================================|");
            System.out.println("|                                Cafe list                                     |");
            System.out.println("|==============================================================================|");
            System.out.printf("| %-7s | %-20s | %-10s | %-15s | %-12s | \n", "Cafe Id", "Cafe Name", "Cafe Price",
                    "Cafe Available", "Cafe Status");
            System.out.println("|==============================================================================|");
            for (Cafe cafe : lis) {
                System.out.printf("| %-7s | %-20s | %-10s | %-15s | %-12s | \n", cafe.getCafeId(), cafe.getCafeName(),
                        cafe.getCafePrice(), cafe.getCafeAvailable(), cafe.getCafeStatus());
                System.out.println("|==============================================================================|");
                

            }
            System.out.println("nhấn phím bất kỳ để quay lại!");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("erroe" + e);
        }

    }
    // public static void orderByMonth(){
    //     while (true) {
    //         int year = 0;
    //         System.out.println("Enter Year : ");
    //         year = input_int();
    //         if (year >= 1990 && year >= 2050 ) {
    //             OrderDAL.
    //         } else {
                
    //         }

    //     }
    // }

    private static int input_int() {
        return 0;
    }
}