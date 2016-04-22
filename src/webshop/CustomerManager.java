package webshop;

import java.util.Collection;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Grp. 14
 */
public class CustomerManager {

    private Map<Integer, Customer> customerMap;
    private static int customerID = 0;
    private static final int PHONENUMBER = 8;

    public CustomerManager() {
        customerMap = new HashMap<>();
    }

    public void createNewOrder(int customerID) {
        getCustomer(customerID).createNewOrder(customerID);
    }

    private int getNextId() {
        return customerID++;
    }

    public Customer createCustomer(String name, String address, int phoneNumber, String email, String password, Date dayOfBirth) {
        Collection<Integer> keys = customerMap.keySet();
        for(Object key: keys){
            if (email==customerMap.get(key).getEmail()) {
                throw new IllegalArgumentException("This E-Mail is already used");
            }
        }
        String number = ""+phoneNumber;
        if (number.length()!=PHONENUMBER) {
            throw new IllegalArgumentException("Phone Number does not exist");
        }     
            int ID = getNextId();
            customerMap.put(ID, new Customer(name, address, email, password, dayOfBirth, phoneNumber));
            return customerMap.get(ID);
        
    }

    public Customer getCustomer(int customerID) {
        if (customerMap.containsKey(customerID)) {
            return customerMap.get(customerID);
        }
        throw new IllegalArgumentException("This customer does not exist");
    }

    public void deleteCustomer(int customerID) {
        customerMap.remove(customerID);
    }

    public void addproduct(Product product, int amount, int customerID) {
        getCustomer(customerID).addProduct(product, amount);
    }
}
