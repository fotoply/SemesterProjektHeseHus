/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshop;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Karim
 */
public class WebshopController {

    Webshop webshop = Webshop.getInstance();
    private int memberShipCardID = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // Test code for products
        WebshopController controller = new WebshopController();

        while (true) {
            System.out.println("Enter 1 to create a new account.\nEnter 2 to login to existing account.\nEnter 0 to exit");
            Scanner input = new Scanner(System.in);
            switch (input.nextInt()) {
                case 1:
                    controller.createAccount(input);
                    break;

                case 0:
                    System.exit(0);
                    break;

                case 2:
                    controller.attemptLogin(input);
                    break;
            }
        }
    }

    private void attemptLogin(Scanner input) {
        input.nextLine();

        System.out.println("Enter email to login:");
        String email = input.nextLine();
        int customerId = webshop.getCustomerIdFromEmail(email);
        if (customerId == -1) {
            System.out.println("Email not found");
            return;
        }

        System.out.println("Enter password for this account: ");
        String password = input.nextLine();

        System.out.println("Password matches: " + webshop.loginWithCustomer(customerId, password));
    }

    private void createAccount(Scanner input) throws ParseException {
        input.nextLine(); // To remove the previous newline from when the number was entered.

        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter address:");
        String address = input.nextLine();
        System.out.println("Enter email:");
        String email = input.nextLine();
        System.out.println("Enter password:");
        String password = input.nextLine();
        System.out.println("Enter birthday (YYYY-MM-DD):");
        DateFormat format = new SimpleDateFormat("YYYY-M-d");
        Date birth = format.parse(input.nextLine());
        System.out.println("Enter phone number:");
        int phoneNumber = Integer.valueOf(input.nextLine());

        Customer newCustomer = webshop.createCustomer(name, address, email, password, birth, phoneNumber);
        System.out.println("You are: " + newCustomer.toString());
    }
}
