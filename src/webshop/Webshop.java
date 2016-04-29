/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshop;

import java.util.Date;

/**
 * @author Karim
 */
public class Webshop {
    private static Webshop instance;
    private int currentCustomerID;
    private CustomerManager customerManager;
    private ProductCatalog productCatalog = new ProductCatalog();

    private Webshop() {
        customerManager = new CustomerManager();
    }

    public static Webshop getInstance() {
        if (instance == null) {
            instance = new Webshop();
        }
        return instance;
    }

    public void setCurrentCustomerID(int currentCustomerID) {
        this.currentCustomerID = currentCustomerID;
    }

    public Product findProduct(int productID) {

        return productCatalog.findProduct(productID);

    }
    
    public String getAllProducts() {
        
        return productCatalog.getAllProducts();
    }

    public Order getCurrentOrder() {
        return customerManager.getCustomer(currentCustomerID).getCurrentOrder();
    }
    
    public void createNewOrder() {
        customerManager.getCustomer(currentCustomerID).createNewOrder(currentCustomerID);
    }

    public void addItem(Product product, int amount) {
        customerManager.getCustomer(currentCustomerID).addProduct(product, amount);
    }

    public Customer createCustomer(String name, String address, String email, String password, Date dayOfBirth, int phoneNumber) {
        return customerManager.createCustomer(name, address, phoneNumber, email, password, dayOfBirth);
    }

    public int getCustomerIdFromEmail(String email) {
        return customerManager.getCustomerIDFromEmail(email);
    }

    public boolean loginWithCustomer(int customerId, String password) {
        if (customerManager.getCustomer(customerId).isCorrectPassword(password)) {
            return true;
        }
        return false;
    }

    public boolean isValidEmail(String email) {
        return customerManager.getCustomerIDFromEmail(email) > -1;
    }

    public boolean loginWithEmail(String email, String password) {
        setCurrentCustomerID(getCustomerIdFromEmail(email));
        System.out.println("Current customer ID: " + getCustomer());
        return loginWithCustomer(getCustomerIdFromEmail(email),password);
    }

    public String checkoutBasket() {
        customerManager.getCustomer(currentCustomerID).checkoutBasket();
        return "Basket was checked out";
    }

    public void cancelOrder() {
        customerManager.getCustomer(currentCustomerID).cancelOrder();
    }

    public Customer getCustomer() {
        return customerManager.getCustomer(currentCustomerID);
    }

    public void deleteCustomer() {
        customerManager.deleteCustomer(currentCustomerID);
    }


}
