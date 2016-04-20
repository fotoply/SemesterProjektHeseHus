/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp14_the_webshop;

import java.util.Date;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author Karim
 */
public class Webshop {
    int currentCustomer;
    CustomerManager customerManager;
    Webshop instance;

    public Webshop getInstance() {
        if(instance == null) {
            instance = new Webshop();
        }
        return instance;
    }

    public Webshop() {
        customerManager = new CustomerManager();
    }

    public Product findProduct(int productID){
        
        throw new NotImplementedException();
    }
    
    public void createNewOrder(){
        customerManager.getCustomer(currentCustomer).createNewOrder();
    }
    
    public void addItem(Product product, int amount){
        customerManager.getCustomer(currentCustomer).addProduct(product,amount);
        throw new NotImplementedException();
    }
    
    public void createCustomer(String name, String address, String email, String password, Date dayOfBirth, int phoneNumber){
        customerManager.createCustomer(name, address, phoneNumber, email, password, dayOfBirth);
    }
    
    public Customer findCustomer(){
        return customerManager.getCustomer(currentCustomer);
    }
    
    public void deleteCustomer(){
        customerManager.deleteCustomer(currentCustomer);
    }
    
}
