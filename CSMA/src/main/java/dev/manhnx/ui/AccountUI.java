package dev.manhnx.ui;

import java.io.IOException;
import java.util.Scanner;
import dev.manhnx.bl.AccountBL;
import dev.manhnx.bl.CafeBL;
import dev.manhnx.bl.OrderBL;

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
            System.out.println("|0.Logout                   |");
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
                                    System.out.println("Insert Complete!!!");
                                    sc.nextLine();
                                    break;
                                case "2":
                                    AccountBL.update();
                                    break;
                                case "3":
                                    AccountBL.showAllAccount();
                                    System.out.println("Press any key to go back!");
                                    sc.nextLine();
                                    break;
                                case "0":
                                    System.exit(0);
                            }
                        }

                    }
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
                                    System.out.println("Insert Complete!!!");
                                    break;
                                case "2":
                                    CafeBL.updateCafe();
                                    System.out.println("Press any key to go back!");
                                sc.nextLine();
                                    break;
                                case "3":
                                CafeBL.showAllCafe();
                                System.out.println("Press any key to go back!");
                                sc.nextLine();
                                break;
                                case "4":
                                    CafeBL.showCafeById();
                                    System.out.println("Press any key to go back!");
                                    sc.nextLine();
                                    break;

                                case "0":
                                    System.exit(0);
                            }
                            // System.out.println("Press any key to go back!!");
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
                                    OrderBL.showOrderById();
                                    System.out.println("Press any key to go back!");
                                sc.nextLine();
                                    break;
                                case "2":

                                    break;
                                case "0":
                                    System.exit(0);

                            }
                        }

                    }

                    break;
                case "0":
                    back = false;
                    break;
                default:
                    System.out.printf("Khong hop le,Nhan %s de quay lai:", "Enter");
                    sc.nextLine();
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
            System.out.println("|1.View Menu                |");
            System.out.println("|2.Manager Order            |");
            System.out.println("|0.Logout                   |");
            System.out.println("=============================");
            System.out.print("   --> Enter your choice: ");
            String chose = sc.nextLine();
            switch (chose) {
                case "1":
                    cls();
                    while (true) {
                        Menu.Product_Staff();
                        System.out.print("Enter the selection: ");
                        chose = sc.nextLine();
                        if (chose.equals("0") == true) {
                            break;
                        } else {
                            switch (chose) {
                                case "1":
                                    CafeBL.showCafeByName();
                                    System.out.println("Press any key to go back!");
                                sc.nextLine();
                                    break;
                                case "2":
                                    CafeBL.showAllCafe();
                                    System.out.println("Press any key to go back!");
                                    sc.nextLine();
                                    break;
                                case "0":
                                    System.exit(0);
                                    break;
                            }
                        }
                    }
                    break;

                case "2":
                    while (true) {
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
                                    System.out.println("Create Bill Comple!!!");
                                    sc.nextLine();
                                    break;
                                case "2":

                                    break;
                                case "0":
                                    System.exit(0);
                                    break;
                            }
                        }

                    }
                    break;
                case "0":
                    back = false;
                    break;
                default:
                    System.out.printf("Khong hop le,Nhan %s de quay lai:", "Enter");
                    sc.nextLine();
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