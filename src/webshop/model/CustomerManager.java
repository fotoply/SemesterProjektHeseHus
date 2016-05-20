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

    public CustomerManager() { }

    public static int getCurrentCustomerID() {
        return currentCustomerID;
    }

    public static void setCurrentCustomerID(int currentCustomerID) {
        CustomerManager.currentCustomerID = currentCustomerID;
    }

    /**
     * Initializes a new order in the given customer
     * @param customerID the unique ID of the customer
     */
    public void createNewOrder(int customerID) {
        getCurrentCustomer(customerID).createNewOrder(customerID);
    }

    /**
     * Gets the next available customerId from the datastore
     * @return an int or -1 if no ID
     */
    private int getNextId() {
        return persistenceFacade.getNextCustomerId();
    }

    /**
     * Creates a new customer based on the given information.
     * Stores this customer in the persistent datastore.
     * @param name name of the customer
     * @param address address of the customer
     * @param phoneNumber phone number of the customer. Must be exactly PHONENUMBER_LENGTH characters long
     * @param email email of the customer
     * @param password plaintext password of the customer
     * @param dayOfBirth birthday of the customer
     * @return returns the newly created customer object
     */
    public Customer createCustomer(String name, String address, int phoneNumber, String email, String password, Date dayOfBirth) {
        Customer temp;
        if (persistenceFacade.confirmEmail(email)) {
            throw new IllegalArgumentException("This E-Mail is already used");
        }

        String number = "" + phoneNumber;
        if (number.length() != PHONENUMBER_LENGTH) {
            throw new IllegalArgumentException("Phone number has a bad length");
        }
        int ID = getNextId();
        temp = new Customer(name, address, email, password, dayOfBirth, phoneNumber);
        temp.setCustomerID(ID);
        persistenceFacade.saveCustomer(temp);
        currentCustomer = temp;
        return temp;

    }

    public Customer getCurrentCustomer(int customerID) {
        if (currentCustomer == null || currentCustomer.getCustomerID() != customerID) {
            currentCustomer = persistenceFacade.loadCustomerFromId(customerID);
        }
        return currentCustomer;
    }

    public int getCustomerIDFromEmail(String email) {
        return persistenceFacade.getCustomerIdFromEmail(email);
    }


    public void addproduct(Product product, int amount, int customerID) {
        getCurrentCustomer(customerID).addProduct(product, amount);
    }
}
