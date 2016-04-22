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

    private Date date;
    private double tax;
    private double shippingCharges;
    private String shippingAddress;
    private int orderID;
    private int customerID;
    private List<Product> productList;
    private int currentlyPaid;

    public Order(double shippingCharges, String shippingAddress, int orderID, int customerID) {
        this.shippingCharges = shippingCharges;
        this.shippingAddress = shippingAddress;
        this.orderID = orderID;
        this.customerID = customerID;
    }

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

    public double getTotalAmountOwed() {

    }

    public void payAmountForOrder(int amount) {

    }

}
