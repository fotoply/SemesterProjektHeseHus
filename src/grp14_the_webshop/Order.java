/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp14_the_webshop;

import java.util.Date;
import java.util.List;

/**
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
    List<Product> productList;

    public void addProduct(Product product, int amount) {
        for (int i = 0; i < amount; i++) {
            productList.add(product);
        }
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    private enum Status {
        SHOPPING_BASKET, ACCEPTED, CLOSED
    }

}
