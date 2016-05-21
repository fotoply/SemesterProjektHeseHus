package webshop.model;

import webshop.database.DatabaseFacade;
import webshop.database.IDatabaseFacade;
import webshop.database.exceptions.NoSuchCustomerException;
import webshop.database.exceptions.NoSuchProductException;
import webshop.model.Inventory.Order;
import webshop.model.Inventory.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles transferring to and from persistent datastore.
 */
public class PersistenceFacade {
    private static PersistenceFacade instance;
    IDatabaseFacade database;

    private PersistenceFacade() {
        database = DatabaseFacade.getInstance();
    }

    public static PersistenceFacade getInstance() {
        if (instance == null) {
            instance = new PersistenceFacade();
        }
        return instance;
    }

    /**
     * Gets the next available customerID.
     *
     * @return The next ID or -1 if no ID was found.
     */
    public int getNextCustomerId() {
        return database.getNextCustomerId();
    }

    /**
     * Loads a customer given a customerID
     *
     * @param customerId the unique ID of the customer
     * @return A customer object with all information set from the database, null if no customer was found
     */
    public Customer loadCustomerFromId(int customerId) {
        ResultSet rs = database.getCustomer(customerId);
        Customer newCustomer = null;
        try {
            if (rs.next()) {
                newCustomer = new Customer(rs.getString("name"), rs.getString("address"), rs.getString("email"), "toBeLoaded", rs.getDate("birthday"), rs.getInt("phonenumber"));
                newCustomer.setPassword(Customer.fromBase64(rs.getString("password")));
                newCustomer.setSalt(Customer.fromBase64(rs.getString("passwordsalt")));
                //  newCustomer.setCurrentOrder(loadOrderFromId(rs.getInt("currentorderid")));
                newCustomer.setCustomerID(customerId);
            } else {
                throw new NoSuchCustomerException(customerId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (newCustomer == null) {
            throw new NoSuchCustomerException(customerId);
        }
        return newCustomer;
    }

    /**
     * Confirms whether the given email exists in the persistent system
     *
     * @param email the email to search for
     * @return true if the email exists otherwise false
     */
    public boolean confirmEmail(String email) {
        return database.emailExists(email);
    }

    /**
     * Saves a Customer object to the database
     *
     * @param c the customer to save
     */
    public void saveCustomer(Customer c) {
        database.saveCustomer(c.getCustomerID(), c.getName(), c.getAddress(), c.getEmail(), Customer.toBase64(c.getPassword()), c.getBirthday(), c.getPhoneNumber(), Customer.toBase64(c.getSalt()), -1);
        //TODO Implement a getter for getting the orderId so that it can be saved.
    }

    /**
     * Loads an order from it's orderId
     *
     * @param orderId the unique ID for the order
     * @return An order object representing the data in the database
     * // TODO: 5/19/16 Finish this method
     */
    public Order loadOrderFromId(int orderId) {
        throw new UnsupportedOperationException();
    }

    /**
     * Loads a product given a productId
     *
     * @param productId the unique ID of the product
     * @return A product object with all information from the database, null if no product was found
     */
    public Product loadProductFromId(int productId) {
        ResultSet rs = database.getProduct(productId);
        Product newProduct = null;

        try {
            if (rs.next()) {
                newProduct = new Product(rs.getString("name"), rs.getString("description"), rs.getString("type"), new Money(rs.getString("price")), productId, rs.getBoolean("currentlyselling"));
            } else {
                throw new NoSuchProductException(productId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (newProduct == null) {
            throw new NoSuchProductException(productId);
        }
        return newProduct;
    }

    /**
     * Gets the unique ID of a customer based on their email. This method is <u>not</u> case sensitive.
     *
     * @param email the email of the user
     * @return the ID of the user or -1 if no user is found
     */
    public int getCustomerIdFromEmail(String email) {
        return database.getCustomerIdFromEmail(email);
    }

    /**
     * Attempts to fetch a product based on the searchTerms
     *
     * @param searchTerms
     * @return A list of the found products
     */
    public List searchProduct(String searchTerms) {
        ResultSet rsType = database.searchProduct(searchTerms);
        List<Product> searchedProducts = new ArrayList<>();
        try {
            while (rsType.next()) {
                searchedProducts.add(new Product(rsType.getString("name"), rsType.getString("description"), rsType.getString("type"), new Money(rsType.getString("price")), rsType.getInt("productID"), rsType.getBoolean("currentlyselling")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (searchedProducts.isEmpty()) {
            throw new NoSuchProductException();
        }

        return searchedProducts;
    }


}
