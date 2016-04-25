/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshop;

import webshop.payments.Payment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Karim
 */
public class Order {

    private static int orderCount = 0;
    private Date date;
    private Money tax;
    private Money shippingCharges;
    private Money finalPrice;
    private String shippingAddress;
    private int orderID;
    private int customerID;
    private List<Item> productList;
    private Money currentlyPaid;
    private List<Payment> paymentMethods;
    private Status status = Status.IN_BASKET;

    public Order() {
        this.paymentMethods = new ArrayList<>();
    }

    public Order(String shippingCharges, String shippingAddress, int customerID) {
        this.shippingCharges = new Money(shippingCharges);
        this.shippingAddress = shippingAddress;
        this.orderID = orderCount;
        this.customerID = customerID;
        this.paymentMethods = new ArrayList<>();
        date = new Date();


        orderCount++;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void addProduct(Product product, int amount) {
        productList.add(new Item(product, amount));
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Money getTotalAmountOwedForProducts() {
        Money owed = new Money();
        for (Item item : productList) {
            for (int i = 0; i < item.getQuantity(); i++) {
                owed.add(item.getProduct().getPrice());
            }
        }
        return owed;
    }

    public int amountOfProductInOrder(int productId) {
        for (Item item : productList) {
            if (item.getProduct().getProductID() == productId) {
                return item.getQuantity();
            }
        }
        return 0;
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

    public Money getFinalPrice() {
        return finalPrice;
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

    public enum Status {
        IN_BASKET, SHIPPING_TO_SHOP, SHIPPING, ACCEPTED, CLOSED, FOR_VERIFICATION
    }
}
