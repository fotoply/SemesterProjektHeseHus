package webshop.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import webshop.database.DatabaseFacade;
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
    DatabaseFacade database;

    private PersistenceFacade() {
        DatabaseFacade.initializeConnection();
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
     * @return The next ID or -1 if no ID was found.
     */
    public int getNextCustomerId() {
        return database.getNextCustomerId();
    }

    public Customer loadCustomerFromId(int customerId) {
        ResultSet rs = database.getCustomer(customerId);
        Customer newCustomer = null;
        try {
            if (rs.next()) {
                newCustomer = new Customer(rs.getString("name"), rs.getString("address"), rs.getString("email"), "toBeLoaded", rs.getDate("birthday"), rs.getInt("phonenumber"));
                newCustomer.setPassword(Customer.fromBase64(rs.getString("password")));
                newCustomer.setSalt(Customer.fromBase64(rs.getString("passwordsalt")));
                newCustomer.setCurrentOrder(loadOrderFromId(rs.getInt("currentorderid")));
                newCustomer.setCustomerID(customerId);
            } else {
                throw new IllegalArgumentException("Customer does not exist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (newCustomer == null) {
            throw new RuntimeException("Something went wrong in initializing a customer from database");
        }
        return newCustomer;
    }

    public boolean confirmEmail(String email) {
        return database.emailExists(email);
    }

    public void saveCustomer(Customer c) {
        database.saveCustomer(c.getName(), c.getAddress(), c.getEmail(), Customer.toBase64(c.getPassword()), c.getBirthday(), c.getPhoneNumber(), Customer.toBase64(c.getSalt()), -1);
        //TODO Implement a getter for getting the orderId so that it can be saved.
    }

    public Order loadOrderFromId(int orderId) {
        throw new NotImplementedException();
    }

    public Product loadProductFromId(int productId) {
        ResultSet rs = database.getProduct(productId);
        Product newProduct = null;

        try {
            if (rs.next()) {
                newProduct = new Product(rs.getString("name"), rs.getString("description"), rs.getString("type"), new Money(rs.getString("price")), productId, rs.getBoolean("currentlyselling"));
            } else {
                throw new IllegalArgumentException("Product does not exist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (newProduct == null) {
            throw new RuntimeException("Something went wrong in initializing a product from database");
        }
        return newProduct;
    }

    public List searchProdut(String searchTerms) {
        ResultSet rsType = database.getProductByType(searchTerms);
        ResultSet rsName = database.getProductByName(searchTerms);
        List<Product> searchedProducts = new ArrayList<>();
        try {
            if (rsType.next()) {
                searchedProducts.add(new Product(rsType.getString("name"), rsType.getString("description"), rsType.getString("type"), new Money(rsType.getString("price")), rsType.getInt("productID"), rsType.getBoolean("currentlyselling")));
            }
            if (rsName.next()) {
                searchedProducts.add(new Product(rsName.getString("name"), rsName.getString("description"), rsName.getString("type"), new Money(rsName.getString("price")), rsName.getInt("productID"), rsName.getBoolean("currentlyselling")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (searchedProducts.isEmpty()) {
            throw new RuntimeException("No products is found");
        }

        return searchedProducts;
    }
}
