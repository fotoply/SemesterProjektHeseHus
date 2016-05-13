package webshop.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import webshop.database.DatabaseFacade;
import webshop.model.Inventory.Order;
import webshop.model.Inventory.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Handles transferring to and from persistent data.
 */
public class PersistenceFacade {
    private static PersistenceFacade instance;
    DatabaseFacade database = DatabaseFacade.getInstance();

    private PersistenceFacade() {

    }

    public static PersistenceFacade getInstance() {
        if (instance == null) {
            instance = new PersistenceFacade();
        }
        return instance;
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
            if(rs.next()) {
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
}
