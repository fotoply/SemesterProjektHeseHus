/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshop;

import java.util.Scanner;

/**
 * @author Karim
 */
public class WebshopController {

    private int memberShipCardID = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test code for products
        Webshop webshop = Webshop.getInstance();
        System.out.println("Enter 1 to create a new account. Enter 0 to exit");
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()) {
            case 1:
                createAccount(input);
                break;

            case 0:
                System.exit(0);
                break;
        }
    }

    private static void createAccount(Scanner input) {

    }
}
