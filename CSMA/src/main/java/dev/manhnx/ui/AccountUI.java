package dev.manhnx.ui;

import java.io.IOException;
import java.util.Scanner;


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
                                    cls();
                                    System.out.println("Table Account :");
                                    AccountUIFunction.showAllAccount();
                                    System.err.println("\n");
                                    AccountUIFunction.insertAcc();
                                    System.out.println("Insert Complete!!!\n");
                                    AccountUIFunction.showAllAccount();
                                    System.out.println("Press enter to back!");
                                    sc.nextLine();
                                    cls();
                                    break;
                                case "2":
                                    cls();
                                    System.out.println("Table Account :");
                                    AccountUIFunction.showAllAccount();
                                    AccountUIFunction.update();
                                    System.out.println("Update Complete!!!\n");
                                    AccountUIFunction.showAllAccount();
                                    System.out.println("Press enter to back!");
                                    sc.nextLine();
                                    cls();
                                    break;
                                case "3":
                                    cls();
                                    AccountUIFunction.showAllAccount();
                                    System.out.println("Press enter to back!");
                                    sc.nextLine();
                                    cls();
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
                        System.out.print("Enter the selection: ");
                        chose = sc.nextLine();
                        if (chose.equals("0") == true) {

                            break;
                        } else {
                            switch (chose) {
                                case "1":
                                    cls();
                                    System.out.println("Table Drinks :");
                                    CafeUIFunction.showAllCafe();
                                    System.out.println("----Insert Drinks----");
                                    CafeUIFunction.insertCafe();
                                    System.out.println("Insert Complete!!!");
                                    CafeUIFunction.showAllCafe();
                                    System.out.println("Press enter to continue!");
                                    sc.nextLine();
                                    cls();
                                    break;
                                case "2":
                                    cls();
                                    System.out.println("Table Drinks :");
                                    CafeUIFunction.showAllCafe();
                                    System.out.println("----Update Drinks----");
                                    CafeUIFunction.updateCafe();
                                    System.out.println("Update Complete!!!");
                                    System.out.println("Press enter to back!");
                                    sc.nextLine();
                                    cls();
                                    break;
                                case "3":
                                    cls();
                                    System.out.println("---- View Drinks----");
                                    CafeUIFunction.showAllCafe();
                                    System.out.println("Press enter to back!");
                                    sc.nextLine();
                                    cls();
                                    break;
                                case "4":
                                    cls();
                                    System.out.println("---- Search Drinks----");
                                    CafeUIFunction.showCafeByName();
                                    System.out.println("Press enter to back!");
                                    sc.nextLine();
                                    cls();
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
                                    OrderUIFuction.showOrderById();
                                    System.out.println("Press enter to back!");
                                    sc.nextLine();
                                    break;
                                // case "2":

                                // break;
                                // case "0":
                                // System.exit(0);

                                // }
                                // }

                                // }

                                // break;
                            }
                        }
                    }
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
            System.out.println("|===========================|");
            System.out.println("|          Menu Staff       |");
            System.out.println("|===========================|");
            System.out.println("|1.View Menu                |");
            System.out.println("|2.Create Order             |");
            System.out.println("|0.Logout                   |");
            System.out.println("|===========================|");
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
                                    cls();
                                    System.out.println("---- Search Drinks----");
                                    CafeUIFunction.showCafeByName();
                                    sc.nextLine();
                                    cls();
                                    while (true) {
                                        String yn = yesno("Do you want to Create order?(y/n)?");
                                        if (yn.equalsIgnoreCase("y")) {
                                            OrderUIFuction.createOrder(staffID);
                                            break;
                                        } else {
                                            cls();
                                            break;
                                        }

                                    }
                                    System.out.println("Press enter to continue!");
                                    sc.nextLine();
                                    cls();
                                    break;

                                case "2":
                                    cls();
                                    CafeUIFunction.showAllCafe();
                                    System.out.println("Press enter to continue ");
                                    sc.nextLine();
                                    cls();
                                    while (true) {
                                        String yn = yesno("Do you want to Create order?(y/n)?");
                                        if (yn.equalsIgnoreCase("y")) {
                                            OrderUIFuction.createOrder(staffID);
                                            cls();
                                            break;
                                        } else {

                                            cls();
                                            break;
                                        }

                                    }
                                    System.out.println("Press enter to continue!");
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
                    // while (true) {

                    cls();
                    OrderUIFuction.createOrder(staffID);
                    System.out.println("Create Bill Comple!!!");
                    sc.nextLine();
                    cls();
                    while (true) {
                        String yn = yesno("Do you want to Create order?(y/n)?");
                        if (yn.equalsIgnoreCase("y")) {
                            OrderUIFuction.createOrder(staffID);
                            cls();
                            break;
                        } else {
                            cls();
                            break;
                        }
                    }
                    cls();
                    break;
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
    // public static String input_string() {
    // final Scanner input = new Scanner(System.in);
    // String a;
    // while (true) {
    // a = input.nextLine();
    // if (a.trim().compareTo("") == 0) {
    // System.out.print(" Wrong type, enter again: ");

    // } else {
    // return a.trim();
    // }
    // }
    // }
    // private static String input_int() {
    // final Scanner input = new Scanner(System.in);
    // String ch;
    // while (true) {
    // ch = input.nextLine();
    // if (ch.trim().compareTo("") == 0) {
    // System.out.print(" Enter incorrectly, please re-enter: ");

    // } else {
    // return ch.trim();
    // }
    // }

    // }
}