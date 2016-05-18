package webshop.model;

import webshop.model.Inventory.Product;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Grp. 14
 */
public class CustomerManager {

    private static final int PHONENUMBER_LENGTH = 8;
    private static int customerID = 0;
    private Map<Integer, Customer> customerMap;
    private PersistenceFacade persistenceFacade = PersistenceFacade.getInstance();

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
        if (persistenceFacade.confirmEmail(email)) {
            throw new IllegalArgumentException("This E-Mail is already used");
        }

        String number = "" + phoneNumber;
        if (number.length() != PHONENUMBER_LENGTH) {
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

    public int getCustomerIDFromEmail(String email) {
        for (int i = 0; i < customerMap.values().size(); i++) {
            Customer customer = customerMap.getOrDefault(i, null);
            if (customer != null && customer.getEmail().equalsIgnoreCase(email)) {
                return i;
            }
        }
        return -1;
    }

    public void deleteCustomer(int customerID) {
        customerMap.remove(customerID);
    }

    public void addproduct(Product product, int amount, int customerID) {
        getCustomer(customerID).addProduct(product, amount);
    }
}
