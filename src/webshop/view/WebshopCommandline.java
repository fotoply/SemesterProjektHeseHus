/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshop.view;

import webshop.Customer;
import webshop.Product;
import webshop.Webshop;

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

        
        
        while (true) {
            System.out.println("Enter 1 to create a new account.\n"
                    + "Enter 2 to login to existing account.\n"
                    + "Enter 3 to add items to basket.\n"
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
                    controller.addToBasket();
                    System.out.println("Add an item from the product catelog to the basket type the ID:\n");
                    switch(input.nextInt()) {
                        case 0:
                            controller.addToOrder(0);
                            break;
                        case 1:
                            controller.addToOrder(1);
                            break;
                        case 2:
                            controller.addToOrder(2);
                            break;
                        case 3:
                            controller.addToOrder(3);
                            break;
                    }
            }
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
    
    private void addToBasket() {
        
        System.out.println(webshop.getAllProducts());
    }
    
    private void addToOrder(int id) {
        //if(webshop.getCurrentOrder() == null) {
            webshop.createNewOrder();
        //}
       
        Product product = webshop.findProduct(id);
        
        System.out.println(product);
        
        webshop.addItem(product, 1);
    }
    
}
