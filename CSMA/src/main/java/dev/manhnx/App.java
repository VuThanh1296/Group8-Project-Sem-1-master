package dev.manhnx;

import java.io.IOException;
import java.util.Scanner;
import dev.manhnx.bl.AccountBL;
import dev.manhnx.ui.AccountUI;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
            while (true) {
                cls(); 
                AccountBL accountbl = new AccountBL();
                AccountUI  accountui = new  AccountUI();
                String username;
                String password;
                System.out.println("==================================|");
                System.out.println("|          [CSMA] Group-8         |");
                System.out.println("|=================================|");
                System.out.println("|--------Login Coffee Shop--------|");
                System.out.println("|=================================|");
                System.out.print("USERNAME : ");
                username = input();      
                System.out.print("PASSWORD : "); 
                password = input();
                int check = accountbl.login_check(username,password);
                if (check == -1) {
                                    System.out.println("Account or password is not correct!");
                                    System.out.printf("Accept %s to continue:", "Enter");
                                    
                                    sc.nextLine();                
                } else if (check == 1) {
                                    accountui.Menu_Admin(check);
                 } else {
                                    accountui.Menu_Staff(check);
                    
                                }
                
            }
        
    }

    private static String input() {
        final Scanner input = new Scanner(System.in);
        String ch;
        while (true) {
            ch = input.nextLine();
            if (ch.trim().compareTo("") == 0) {
                System.out.print(" Enter incorrectly, please re-enter: \n ");
                
            } else {
                return ch.trim();
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
    public static String input_string() {
        final Scanner input = new Scanner(System.in);
        String a;
        while (true) {
            a = input.nextLine();
            if (a.trim().compareTo("") == 0) {
                System.out.print("  Wrong type, enter again: ");

            } else {
                return a.trim();
            }
        }

    }

   public static boolean isEmptyString(String input){
       if (input.trim().isEmpty() || input == null) {
           return true;
       }
       return false;
   }

}
