package dev.manhnx.ui;

import java.io.IOException;

public class Menu {
    public static void MenuAcc(){
        cls();
        System.out.println("|============================|");
        System.out.println("|       [CSMA] Group-8       |");
        System.out.println("|============================|");
        System.out.println("|        Manage Staff        |");
        System.out.println("|============================|");
        System.out.println("|1. Create Account           |");
        System.out.println("|2. Update Account           |");
        System.out.println("|3. View Profile             |");
        System.out.println("|0. Exit                     |");
        System.out.println("|============================|");
    }
    public static void MenuCafe(){
        cls();
        System.out.println("|============================|");
        System.out.println("|        [CSMA] Group-8      |");
        System.out.println("|============================|");
        System.out.println("|        Manage Cafe         |");
        System.out.println("|============================|");
        System.out.println("|1. Insert Drinks            |");
        System.out.println("|2. Update Drinks            |");
        System.out.println("|3. View Drinks              |");
        System.out.println("|4. Search Drinks            |");
        System.out.println("|0. Exit                     |");
        System.out.println("|============================|");
    }
    public static void MenuOrder(){
        cls();
        System.out.println("|============================|");
        System.out.println("|        [CSMA] Group-8      |");
        System.out.println("|============================|");
        System.out.println("|        Manage Order        |");
        System.out.println("|============================|");
        System.out.println("|1. View and Search Bill     |");
        // System.out.println("|2. Revenue                  |");
        System.out.println("|0. Exit                     |");
        System.out.println("|============================|");
    }
    public static void Product_Staff(){
       cls();
        System.out.println("|===========================|");
        System.out.println("|           Group-8         |");
        System.out.println("|===========================|");
        System.out.println("|        Order Staff        |");
        System.out.println("|===========================|");
        System.out.println("|1.Search Drinks            |");
        System.out.println("|2.Show Drinks              |");
        System.out.println("|0.Exit                     |");
        System.out.println("|===========================|");
    }
    // public static void Order_Staff(){
    //     System.out.println("=============================");
    //     System.out.println("|           Group-8         |");
    //     System.out.println("=============================");
    //     System.out.println("|       Manager Order       |");
    //     System.out.println("=============================");
    //     System.out.println("|1.Cearte Bill              |");
    //     System.out.println("|2.Update Bill              |");
    //     System.out.println("|0.Exit                     |");
    //     System.out.println("=============================");
    // }
    public static void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ignored) {
        }
    }
}