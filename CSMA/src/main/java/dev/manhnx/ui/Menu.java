package dev.manhnx.ui;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class Menu {
    public static void MenuAcc(){
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
        System.out.println("|============================|");
        System.out.println("|        [CSMA] Group-8      |");
        System.out.println("|============================|");
        System.out.println("|        Manage Cafe         |");
        System.out.println("|============================|");
        System.out.println("|1. Insert Cafe              |");
        System.out.println("|2. Update Cafe              |");
        System.out.println("|3. View Cafe                |");
        System.out.println("|4. Search Cafe              |");
        System.out.println("|0. Exit                     |");
        System.out.println("|============================|");
    }
    public static void MenuOrder(){
        System.out.println("|============================|");
        System.out.println("|        [CSMA] Group-8      |");
        System.out.println("|============================|");
        System.out.println("|        Manage Order        |");
        System.out.println("|============================|");
        System.out.println("|1. View and Search Bill     |");
        System.out.println("|2. Revenue                  |");
        System.out.println("|0. Exit                     |");
        System.out.println("|============================|");
    }
    public static void Product_Staff(){
        System.out.println("=============================");
        System.out.println("|           Group-8         |");
        System.out.println("=============================");
        System.out.println("|        Manager Product    |");
        System.out.println("=============================");
        System.out.println("|1.Show Product             |");
        System.out.println("|2.Search Product           |");
        System.out.println("|0.Exit                     |");
        System.out.println("=============================");
    }
    public static void Order_Staff(){
        System.out.println("=============================");
        System.out.println("|           Group-8         |");
        System.out.println("=============================");
        System.out.println("|       Manager Order       |");
        System.out.println("=============================");
        System.out.println("|1.Cearte Bill              |");
        System.out.println("|2.Update Bill              |");
        System.out.println("|3.Complete Bill            |");
        System.out.println("|0.Exit                     |");
        System.out.println("=============================");
    }
}