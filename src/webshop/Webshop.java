/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshop;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;

/**
 * @author Karim
 */
public class Webshop {
    private int currentCustomerID;
    private CustomerManager customerManager;
    private Webshop instance;

    public Webshop() {
        customerManager = new CustomerManager();
    }

    public Webshop getInstance() {
        if (instance == null) {
            instance = new Webshop();
        }
        return instance;
    }

    public Product findProduct(int productID) {

        throw new NotImplementedException();
    }

    public void createNewOrder() {
        customerManager.getCustomer(currentCustomerID).createNewOrder(currentCustomerID);
    }

    public void addItem(Product product, int amount) {
        customerManager.getCustomer(currentCustomerID).addProduct(product, amount);
        throw new NotImplementedException();
    }

    public Customer createCustomer(String name, String address, String email, String password, Date dayOfBirth, int phoneNumber) {
        return customerManager.createCustomer(name, address, phoneNumber, email, password, dayOfBirth);
    }

    public String checkoutBasket() {
        customerManager.getCustomer(currentCustomerID).checkoutBasket();
        return "Basket was checked out";
    }

    public void cancelOrder() {
        customerManager.getCustomer(currentCustomerID).cancelOrder();
    }

    public Customer findCustomer() {
        return customerManager.getCustomer(currentCustomerID);
    }

    public void deleteCustomer() {
        customerManager.deleteCustomer(currentCustomerID);
    }

}
