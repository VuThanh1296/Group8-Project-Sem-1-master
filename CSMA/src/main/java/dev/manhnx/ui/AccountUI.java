package dev.manhnx.ui;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import dev.manhnx.ui.*;
import dev.manhnx.bl.AccountBL;
import dev.manhnx.bl.CafeBL;
import dev.manhnx.bl.OrderBL;
import dev.manhnx.dal.AccountDAL;
import dev.manhnx.persistance.Cafe;

public class AccountUI {
    static Scanner sc = new Scanner(System.in);

    public static void Menu_Admin(int id) {
        boolean back = true;
        while (back) {
            cls();
            System.out.println("=============================");
            System.out.println("|           Group-8         |");
            System.out.println("=============================");
            System.out.println("|          Menu Admin       |");
            System.out.println("=============================");
            System.out.println("|1.Manager Staff            |");
            System.out.println("|2.Manager Cafe             |");
            System.out.println("|3.Manager Order            |");
            System.out.println("|4.Logout                   |");
            System.out.println("|5.Exit                     |");
            System.out.println("=============================");
            System.out.print("   --> Enter your choice: ");
            String chose = sc.nextLine();
            switch (chose) {
                case "1":
                    cls();
                    while (true) {
                        Menu.MenuAcc();
                        System.out.print("Enter the selection: ");
                        chose = sc.nextLine();
                        if (chose.equals("0") == true) {
                            break;
                        } else {
                            switch (chose) {
                                case "1":
                                    AccountBL.insertAcc();
                                    break;
                                case "2":
                                    AccountBL.update();
                                    System.out.println("Press enter to back!");
                                    sc.nextLine();
                                    break;
                                case "3":
                                    AccountBL.showAllAccount();
                                    System.out.println("Press enter to back!");
                                    sc.nextLine();
                                    break;
                                case "0":
                                    System.exit(0);
                            }
                        }

                    }
                    break;
                case "2":
                    cls();
                    while (true) {
                        Menu.MenuCafe();
                        ;
                        System.out.print("Enter the selection: ");
                        chose = sc.nextLine();
                        if (chose.equals("0") == true) {
                            break;
                        } else {
                            switch (chose) {
                                case "1":
                                    CafeBL.insertCafe();
                                    break;
                                case "2":
                                    CafeBL.updateCafe();
                                    break;
                                case "3":
                                List<Cafe> cafes = new CafeBL().getALLCafe();
                                CafeBL.showAllCafe(cafes);
                                System.out.println("Press enter to back!");
                                sc.nextLine();
                                    
                                    break;
                                case "4":
                                    CafeBL.showCafeByName();
                                    break;

                                case "0":
                                    System.exit(0);
                            }
                            // System.out.println("nhấn phím bất kỳ để quay lại");
                        }

                    }

                    break;
                case "3":
                    cls();
                    while (true) {
                        Menu.MenuOrder();
                        System.out.print("Enter the selection: ");
                        chose = sc.nextLine();
                        if (chose.equals("0") == true) {
                            break;
                        } else {
                            switch (chose) {
                                case "1":
                                    OrderBL.showCafeById();
                                    break;
                                case "2":

                                    break;
                                case "0":
                                    System.exit(0);

                            }
                        }

                    }

                    break;
                case "4":
                    back = false;
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.printf("Khong hop le,Nhan %s de quay lai:", "Enter");
                    String nh = sc.nextLine();
            }
        }
    }

    public static void Menu_Staff(int staffID) {
        boolean back = true;
        while (back) {
            cls();
            System.out.println("=============================");
            System.out.println("|           Group-8         |");
            System.out.println("=============================");
            System.out.println("|          Menu Staff       |");
            System.out.println("=============================");
            System.out.println("|1.Manager Product          |");
            System.out.println("|2.Manager Order            |");
            System.out.println("|3.Logout                   |");
            System.out.println("|0.Exit                     |");
            System.out.println("=============================");
            System.out.print("   --> Enter your choice: ");
            String chose = sc.nextLine();
            switch (chose) {
                case "1":
                    cls();
                    while (true) {
                        Menu.Product_Staff();
                        ;
                        System.out.print("Enter the selection: ");
                        chose = sc.nextLine();
                        if (chose.equals("0") == true) {
                            break;
                        } else {
                            switch (chose) {
                                case "1":
                                List<Cafe> cafes = new CafeBL().getALLCafe();

                                    CafeBL.showAllCafe(cafes);
                                    System.out.println("nhấn phím bất kỳ để quay lại!");
                                    sc.nextLine();
                                    break;
                                case "2":
                                    CafeBL.showCafeByName();
                                    break;
                                case "0":
                                    System.exit(0);
                            }
                        }
                    }
                    break;

                case "2":
                    cls();
                    Menu.Order_Staff();
                    ;
                    System.out.print("Enter the selection: ");
                    chose = sc.nextLine();
                    if (chose.equals("0") == true) {
                        break;
                    } else {
                        switch (chose) {
                            case "1":
                                OrderBL.createOrder(staffID);
                                break;
                            case "2":

                                break;
                            case "0":
                                System.exit(0);
                        }
                    }
                    break;
                case "3":
                    back = false;
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.printf("Khong hop le,Nhan %s de quay lai:", "Enter");
                    final String nh = sc.nextLine();
            }
        }
    }

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