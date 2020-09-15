package dev.manhnx.ui;

import java.io.IOException;
import java.util.Scanner;
import dev.manhnx.App;

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
            System.out.println("|2.Manager Drinks           |");
            // System.out.println("|3.Manager Order |");
            System.out.println("|0.Logout                   |");
            // System.out.println("|4.Exit |");
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
                                    // App.cls();
                                    System.out.println("Table Account :");
                                    AccountUIFunction.showAllAccount();
                                    System.out.println("Insert Account :");
                                    AccountUIFunction.insertAcc();
                                    System.out.println("Press enter to back!");
                                    sc.nextLine();
                                    App.cls();

                                    break;
                                case "2":
                                    // App.cls();
                                    System.out.println("\n");
                                    AccountUIFunction.showAllAccount();
                                    System.out.println("Update Account :");
                                    AccountUIFunction.update();
                                    System.out.println("\n");
                                    AccountUIFunction.showAllAccount();
                                    System.out.println("Press enter to back!");
                                    sc.nextLine();

                                    App.cls();
                                    break;
                                case "3":
                                    App.cls();
                                    AccountUIFunction.showAllAccount();
                                    System.out.println("Press enter to back!");
                                    sc.nextLine();
                                    App.cls();
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
                                    // App.cls();
                                    System.out.println("Table Drinks :");
                                    CafeUIFunction.showAllCafe();
                                    System.out.println("Insert Drinks :");
                                    CafeUIFunction.insertCafe();
                                    System.out.println("\n");
                                    CafeUIFunction.showAllCafe();
                                    System.out.println("Press enter to continue!");
                                    sc.nextLine();
                                    App.cls();
                                    break;
                                case "2":
                                    // App.cls();
                                    System.out.println("Table Drinks :");
                                    CafeUIFunction.showAllCafe();
                                    System.out.println("Update Drinks");
                                    CafeUIFunction.updateCafe();
                                    System.out.println("Table Drinks :");
                                    CafeUIFunction.showAllCafe();
                                    System.out.println("Press enter to back!");
                                    sc.nextLine();
                                    App.cls();
                                    break;
                                case "3":
                                    CafeUIFunction.showAllCafe();
                                    System.out.println("Press enter to back!");
                                    sc.nextLine();
                                    App.cls();
                                    break;
                                case "4":
                                    App.cls();
                                    CafeUIFunction.showCafeByName();
                                    System.out.println("Press enter to back!");
                                    sc.nextLine();
                                    App.cls();
                                    break;

                                case "0":
                                    System.exit(0);
                            }
                            // System.out.println("nhấn phím bất kỳ để quay lại");
                        }

                    }

                    break;
                // case "3":
                // cls();
                // while (true) {
                // Menu.MenuOrder();
                // System.out.print("Enter the selection: ");
                // chose = sc.nextLine();
                // if (chose.equals("0") == true) {
                // break;
                // } else {
                // switch (chose) {
                // case "1":
                // OrderUIFuction.showOrderById();
                // break;
                // case "2":

                // break;
                // case "0":
                // System.exit(0);

                // }
                // }

                // }

                // break;
                case "0":
                    back = false;
                    break;

                default:
                    System.out.printf("error Press %s :", "Enter to back");
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
            System.out.println("|2.Create Orrder            |");
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
                                  
                                    CafeUIFunction.showCafeByName();
                                    System.out.println("\n");
                                    System.out.println("Do you want Create Order ?");
                                    String yn = yesno("Do you want to add cafe to order?(y/n)?");
                                    if (yn.equalsIgnoreCase("y")) {
                                        OrderUIFuction.createOrder(staffID);
                                    } else {
                                        cls();
                                        break;
                                    }
                                    // System.out.println("Press enter to back!");
                                    // sc.nextLine();
                                    // cls();
                                    break;
                                case "2":
                                    // App.cls();
                                    CafeUIFunction.showAllCafe();
                                    System.out.println("Press enter to back!");
                                    sc.nextLine();
                                    cls();
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
                        OrderUIFuction.createOrder(staffID);
                        System.out.println("Create Bill Comple!!!");
                        sc.nextLine();
                        System.out.println("Do you want to Create More Order ?");
                        System.out.println("\n");
                        while (true) {
                            String yn = yesno("Do you want to add cafe to order?(y/n)?");
                            if (yn.equalsIgnoreCase("y")) {
                                OrderUIFuction.createOrder(staffID);
                                System.out.println("Create Bill Comple!!!");
                                sc.nextLine();
                            } else {
                                break;
                            }
                          
                        }
                        // sc.nextLine();
                        cls();
                        break;
                    }

                    break;
                case "0":
                    back = false;
                    break;
                default:
                    System.out.printf("error Press %s :", "Enter to back");
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