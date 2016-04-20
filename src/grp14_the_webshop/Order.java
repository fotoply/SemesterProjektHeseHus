/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp14_the_webshop;

import java.util.Date;

/**
 *
 * @author Karim
 */
public class Order {

    Date date;
    double tax;
    double shippingCharges;
    double totalPrice;
    String shippingAddress;
    int orderID;
    int customerID;

    private enum Status {
        ShoppingBasket, acceptede, closede
    };

    public void addProduct(Product product, int amount) {

    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

}
