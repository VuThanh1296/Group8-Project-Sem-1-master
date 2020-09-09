package dev.manhnx.ui;

import java.util.List;
import java.util.Scanner;

import dev.manhnx.bl.CafeBL;
import dev.manhnx.persistance.Cafe;

public class CafeUIFunction {
    static CafeBL cbl = new CafeBL();
    static Scanner sc = new Scanner(System.in);

    public static void showAllCafe() {
        List<Cafe> cafes = new CafeBL().getALLCafe();

        try {

            System.out.println("|==============================================================================|");
            System.out.println("|                            [CSMA] Group-08                                   |");
            System.out.println("|==============================================================================|");
            System.out.println("|                                Cafe list                                     |");
            System.out.println("|==============================================================================|");
            System.out.printf("| %-7s | %-20s | %-10s | %-15s | %-12s | \n", "Cafe Id", "Cafe Name", "Cafe Price",
                    "Cafe Amount", "Cafe Status");
            System.out.println("|==============================================================================|");
            for (Cafe cafe : cafes) {
                System.out.printf("| %-7s | %-20s | %-10s | %-15s | %-12s | \n", cafe.getCafeId(), cafe.getCafeName(),
                        cafe.getCafePrice(), cafe.getCafeAmount(), cafe.getCafeStatus());
                System.out.println("|==============================================================================|");

            }

        } catch (Exception e) {
            System.out.println("erroe" + e);
        }

    }

    public static void insertCafe() {
        CafeBL cbl = new CafeBL();
        System.out.println("Insert new Cafe:");
        try {
            cbl.addCafe(inputCafe());
            System.out.println("Insert complete!");
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

    public static Cafe inputCafe() {
        Cafe cafe = new Cafe();
        System.out.print("Cafe Id: ");
        cafe.setCafeId(Integer.parseInt(sc.nextLine()));
        System.out.print("Cafe Name: ");
        cafe.setCafeName(sc.nextLine());
        System.out.print("Cafe Price:");
        cafe.setCafePrice(Double.parseDouble(sc.nextLine()));
        System.out.print("Available: : ");
        cafe.setCafeAmount(Integer.parseInt(sc.nextLine()));
        return cafe;
    }

    public static void updateCafe() {
        // AccountBL abl = new AccountBL();
        Scanner sc = new Scanner(System.in);
        try  {
            cbl.updateCafe(inputInfo());
            System.out.println("update complete");

        }
        catch(Exception e) {
            System.out.println("error"+e);
        }
            
        

        // sc.nextLine();

    }

    public static Cafe inputInfo() {
        Cafe cafe = new Cafe();
        Scanner sc = new Scanner(System.in);
        System.out.print("Cafe_Id: ");
        cafe.setCafeId(Integer.parseInt(sc.nextLine()));
        // System.out.print("New Cafe_Id: ");
        // cafe.setCafeId(Integer.parseInt(sc.nextLine()));
        System.out.print("New Cafe_Name: ");
        cafe.setCafeName(sc.nextLine());
        System.out.print("New Cafe_Price: ");
        cafe.setCafePrice(Double.parseDouble(sc.nextLine()));
        System.out.print("New Cafe_Amount: ");
        cafe.setCafeAmount(Integer.parseInt(sc.nextLine()));
        System.out.print("New Cafe_Status: ");
        cafe.setCafeStatus(Integer.parseInt(sc.nextLine()));
        // sc.close();
        return cafe;
    }

    public static void showCafeById() {

        CafeBL cbl = new CafeBL();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = Integer.parseInt(sc.nextLine());
        List<Cafe> lst = cbl.getbyId(id);
        try {

            System.out.println("|==============================================================================|");
            System.out.println("|                            [CSMA] Group-08                                   |");
            System.out.println("|==============================================================================|");
            System.out.println("|                                Cafe list                                     |");
            System.out.println("|==============================================================================|");
            System.out.printf("| %-7s | %-20s | %-10s | %-15s | %-12s | \n", "Cafe Id", "Cafe Name", "Cafe Price",
                    "Cafe Amount", "Cafe Status");
            System.out.println("|==============================================================================|");
            for (Cafe cafe : lst) {
                System.out.printf("| %-7s | %-20s | %-10s | %-15s | %-12s | \n", cafe.getCafeId(), cafe.getCafeName(),
                        cafe.getCafePrice(), cafe.getCafeAmount(), cafe.getCafeStatus());
                System.out.println("|==============================================================================|");

            }
            // System.out.println("nhap Enter de tiep tuc");
            // sc.nextLine();
        } catch (Exception e) {
            System.out.println("erroe" + e);
        }

    }

    public static void showCafeByName() {

        CafeBL cfbl = new CafeBL();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        List<Cafe> lis = cbl.getbyName(name);

        try {

            System.out.println("|==============================================================================|");
            System.out.println("|                            [CSMA] Group-08                                   |");
            System.out.println("|==============================================================================|");
            System.out.println("|                                Cafe list                                     |");
            System.out.println("|==============================================================================|");
            System.out.printf("| %-7s | %-20s | %-10s | %-15s | %-12s | \n", "Cafe Id", "Cafe Name", "Cafe Price",
                    "Cafe Amount", "Cafe Status");
            System.out.println("|==============================================================================|");
            for (Cafe cafe : lis) {
                System.out.printf("| %-7s | %-20s | %-10s | %-15s | %-12s | \n", cafe.getCafeId(), cafe.getCafeName(),
                        cafe.getCafePrice(), cafe.getCafeAmount(), cafe.getCafeStatus());
                System.out.println("|==============================================================================|");

            }
            // System.out.println("nhấn phím bất kỳ để quay lại!");
            // sc.nextLine();
        } catch (Exception e) {
            System.out.println("erroe" + e);
        }

    }
}
