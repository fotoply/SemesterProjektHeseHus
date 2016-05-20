package webshop.model;

import webshop.model.Inventory.Product;

import java.util.Date;

public class CustomerManager {

    private static final int PHONENUMBER_LENGTH = 8;
    private static int customerID = 0;
    private static Customer currentCustomer;
    private static int currentCustomerID = -1;
    //private Map<Integer, Customer> customerMap;
    private PersistenceFacade persistenceFacade = PersistenceFacade.getInstance();

    public CustomerManager() {
    }

    public static int getCurrentCustomerID() {
        return currentCustomerID;
    }

    public static void setCurrentCustomerID(int currentCustomerID) {
        CustomerManager.currentCustomerID = currentCustomerID;
    }

    public void createNewOrder(int customerID) {
        getCustomer(customerID).createNewOrder(customerID);
    }

    private int getNextId() {
        return persistenceFacade.getNextCustomerId();
    }

    public Customer createCustomer(String name, String address, int phoneNumber, String email, String password, Date dayOfBirth) {
        Customer temp;
        if (persistenceFacade.confirmEmail(email)) {
            throw new IllegalArgumentException("This E-Mail is already used");
        }

        String number = "" + phoneNumber;
        if (number.length() != PHONENUMBER_LENGTH) {
            throw new IllegalArgumentException("Phone Number does not exist");
        }
        int ID = getNextId();
        temp = new Customer(name, address, email, password, dayOfBirth, phoneNumber);
        temp.setCustomerID(getNextId());
        persistenceFacade.saveCustomer(temp);
        currentCustomer = temp;
        return temp;

    }

    public Customer getCustomer(int customerID) {
        if (currentCustomer == null || currentCustomer.getCustomerID() != customerID) {
            currentCustomer = persistenceFacade.loadCustomerFromId(customerID);
        }
        return currentCustomer;
    }

    public int getCustomerIDFromEmail(String email) {
        return persistenceFacade.getCustomerIdFromEmail(email);
    }


    public void addproduct(Product product, int amount, int customerID) {
        getCustomer(customerID).addProduct(product, amount);
    }
}
