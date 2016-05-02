/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshop.view;

import webshop.model.Customer;
import webshop.model.Item;
import webshop.model.Product;
import webshop.model.Webshop;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Karim
 */
public class WebshopCommandline {

    Webshop webshop = Webshop.getInstance();
    private int memberShipCardID = 0;

    //webshop.createCustomer("Bob", "Campusvej 55", "bob@bob.dk", "1234", 1990-12-21, 11223344);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // Test code for products
        WebshopCommandline controller = new WebshopCommandline();
        controller.webshop.createCustomer("Bob","Vester bobvej", "test", "1", new Date(), 10203040);

        while (true) {
            System.out.println("**testbruger: navn: test kode: 1** \n"
                    + "Enter 1 to create a new account.\n"
                    + "Enter 2 to login to existing account.\n"
                    + "Enter 3 to add items to basket.\n"
                    + "Enter 4 to go to checkout.\n"
                    + "Enter 0 to exit");
            Scanner input = new Scanner(System.in);
            switch (input.nextInt()) {
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    controller.createAccount(input);
                    break;

                case 2:
                    controller.attemptLogin(input);
                    break;

                case 3:
                    controller.handleBasket(input);
                    break;

                case 4:
                    if(!controller.checkoutCustomer(input)) {
                        controller.cancelOrder();
                    }
                    break;
            }
        }
    }

    private void cancelOrder() {
        webshop.cancelOrder();
    }

    private void handleBasket(Scanner input) {
        showAllProducts();
        System.out.println("Add an item from the product catelog to the basket type the ID:\n");
        addToOrder(input.nextInt());
    }

    private boolean checkoutCustomer(Scanner input) {
        input.nextLine();
        webshop.checkoutBasket();
        
        try {
            if (webshop.getCustomer() == null || webshop.getCurrentOrder() == null) {
                System.out.println("You cannot checkout without an account or basket");
                return true;
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        System.out.println("Type 'cancel' at any time to cancel");
        System.out.println("Your basket contains:");
        showBasket();
        System.out.println("Total price: " + webshop.getCurrentOrder().getFinalPrice());

        System.out.println("Do you wish to apply a giftcard? (Y/N)");
        String nextString = input.nextLine();
        if(nextString.equalsIgnoreCase("cancel")) return false;
        if(nextString.toLowerCase().equals("y")) {
            System.out.println("Please enter giftcard ID");
            int giftcardId = input.nextInt();
            webshop.applyGiftCard(giftcardId);
            System.out.println("Giftcard was applied");
        }

        if(!webshop.isOrderPaidFor()) {
            int choice = 0;
            System.out.println("How do you wish to pay? 0 for by credit card and 1 for in-shop:");
            choice = input.nextInt();

            if(choice == 0) {
                webshop.setPayingBy(Webshop.paymentType.CREDIT_CARD);
            } else if(choice == 1) {
                webshop.setPayingBy(Webshop.paymentType.IN_SHOP);
            } else {
                System.out.println("Invalid choice, credit card was substituted");
                webshop.setPayingBy(Webshop.paymentType.CREDIT_CARD);
            }

            if (webshop.getPayingBy() == Webshop.paymentType.CREDIT_CARD) {
                System.out.println("Please press enter to continue to the payment processors site.");
                input.nextLine();
                System.out.println("Payment for the remaining was received");
            }
        }

        System.out.println("Your address is: " + webshop.getCurrentOrder().getShippingAddress());

        
        input.nextLine();
        return true;
    }

    private void showBasket() {
        System.out.printf("%-20s%-10s%-10s", "Product name", "Price", "Amount");
        System.out.println();
        for (Item item : webshop.getCurrentOrder().getProducts()) {
            System.out.printf("%-20s%-10s%-10d", item.getProduct().getName(), item.getProduct().getPrice().toString(), item.getQuantity());
            System.out.println();
        }
    }

    private void attemptLogin(Scanner input) {
        input.nextLine();

        System.out.println("Enter email to login:");
        String email = input.nextLine();
        if (!webshop.isValidEmail(email)) {
            System.out.println("Email not found");
            return;
        }

        System.out.println("Enter password for this account: ");
        String password = input.nextLine();

        System.out.println("Password matches: " + webshop.loginWithEmail(email, password));
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
        System.out.println("Your password hash is: " + Customer.toBase64(newCustomer.getPassword()));
    }

    private void showAllProducts() {
        System.out.println(webshop.getAllProducts());
    }

    private void addToOrder(int id) {
        if(webshop.getCurrentOrder() == null) {
            webshop.createNewOrder();
        }

        Product product = webshop.findProduct(id);

        System.out.println(product);

        webshop.addItem(product, 1);
    }

}
