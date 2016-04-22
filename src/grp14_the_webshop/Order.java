/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp14_the_webshop;

import grp14_the_webshop.payments.Payment;

import java.util.ArrayList;
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
    private List<Payment> paymentMethods;

    public Order() {
        this.paymentMethods = new ArrayList<>();
    }

    public Order(String shippingCharges, String shippingAddress, int orderID, int customerID) {
        this.shippingCharges = new Money(shippingCharges);
        this.shippingAddress = shippingAddress;
        this.orderID = orderID;
        this.customerID = customerID;
        this.paymentMethods = new ArrayList<>();
    }

    public void addProduct(Product product, int amount) {
        for (int i = 0; i < amount; i++) {
            productList.add(product);
        }
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Money getTotalAmountOwedForProducts() {
        Money owed = new Money();
        for (Product product : productList) {
            owed.add(product.getPrice());
        }
        return owed;
    }

    public int amountOfProductInOrder(int productId) {
        int count = 0;
        for (Product product : productList) {
            if (product.getProductID() == productId) {
                count++;
            }
        }
        return count;
    }

    public void setPaymentMethod(Payment method) {
        this.paymentMethods.add(method);
    }

    public Money getTax(Money price) {
        return tax;
    }

    public Money getShippingCharges() {
        return shippingCharges;
    }

    public void payAmountForOrder(Money amount) {
        if (amount.compareTo(getTotalAmountOwedForProducts()) > 0) {
            throw new IllegalArgumentException("Trying to pay more than owed");
        } else {
            currentlyPaid.add(amount);
        }
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    private enum Status {
        IN_BASKET, SHIPPING_TO_SHOP, SHIPPING, ACCEPTED, CLOSED
    }
}
