
package grp14_the_webshop;

import java.util.*;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author Grp. 14
 */
public class CustomerManager {
    
    private Map<Integer,Customer> customerMap;
    
    public CustomerManager() {
        customerMap = new HashMap<>();
    }
    
    public void createNewOrder(int customerID){
        throw new NotImplementedException();
    }

    private int getNextId() {
        throw new NotImplementedException();
    }
    
    public void createCustomer(String name, String address, int phoneNumber, String email, String password, Date dayOfBirth){
        customerMap.put(getNextId(),new Customer(name, address, email, password, dayOfBirth, phoneNumber));
        throw new NotImplementedException();
    }
    
    public Customer getCustomer(int customerID){
        if(customerMap.containsKey(customerID)) {
            return customerMap.get(customerID);
        }
        throw new IllegalArgumentException("This customer does not exist");
    }
    
    public void deleteCustomer(int customerID){
        customerMap.remove(customerID);
    }
    
    public void addproduct(Product product, int amount, int customerID){
        throw new NotImplementedException();
    }
}
