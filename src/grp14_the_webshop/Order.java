/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp14_the_webshop;

import java.util.Currency;
import java.util.Date;
import java.util.List;

/**
 * @author Karim
 */
public class Order {

    private Date date;
    private Money tax;
    private Money shippingCharges;
    private String shippingAddress;
    private int orderID;
    private int customerID;
    private List<Product> productList;
    private Money currentlyPaid;

    public Order(String shippingCharges, String shippingAddress, int orderID, int customerID) {
        this.shippingCharges = new Money(shippingCharges);
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

    public Money getTotalAmountOwed() {
        Money owed = new Money();
        for (Product product: productList) {
            owed.add(product.getPrice());
        }
    }

    public void payAmountForOrder(Money amount) {

    }

}
