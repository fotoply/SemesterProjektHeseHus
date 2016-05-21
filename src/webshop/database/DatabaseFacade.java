package webshop.database;

import webshop.database.exceptions.NoSuchCustomerException;
import webshop.database.exceptions.NoSuchOrderException;
import webshop.database.exceptions.NoSuchProductException;
import webshop.model.Inventory.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class DatabaseFacade implements IDatabaseFacade {

    private static DatabaseConnector databaseConnector = new PostgresConnectionDriver();
    private static DatabaseFacade instance;

    private DatabaseFacade() {
        databaseConnector.getConnection();
    }

    public static IDatabaseFacade getInstance() {
        if (instance == null) {
            instance = new DatabaseFacade();
        }
        return instance;
    }

    /**
     * Checks whether a given email is currently in use in the database. This method is <u>not</u> case sensitive.
     *
     * @param email the email to check
     * @return true if the email exists otherwise false
     */
    @Override
    public boolean emailExists(String email) {
        ResultSet rs;
        try {
            rs = databaseConnector.executeQuery("SELECT email FROM customer WHERE email='" + email.toLowerCase() + "'");
            return rs.isBeforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();


        }
        throw new RuntimeException("Something went wrong in executing SQL statement.");

    }

    /**
     * Gets the ResultSet representing a customers information.
     *
     * @param customerId the customers unique ID
     * @return A ResultSet containing all columns of the customer
     */
    @Override
    public ResultSet getCustomer(int customerId) {
        try {
            return databaseConnector.executeQuery("SELECT * FROM customer WHERE customerid=" + customerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NoSuchCustomerException(customerId);
    }

    /**
     * Gets the ResultSet representing a products information in the database.
     *
     * @param productId the products unique ID
     * @return A ResultSet containing all columns of the product
     */
    @Override
    public ResultSet getProduct(int productId) {
        try {
            return databaseConnector.executeQuery("SELECT * FROM product WHERE productId=" + productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NoSuchProductException(productId);
    }

    /**
     * Gets the ResultSet representing an orders information in the database.
     *
     * @param orderId the orders unique ID
     * @return A ResultSet containing all columns of the order
     */
    @Override
    public ResultSet getOrder(int orderId) {
        try {
            return databaseConnector.executeQuery("SELECT * FROM orderinfo WHERE orderId=" + orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NoSuchOrderException(orderId);
    }

    /**
     * Returns the unique ID for a customer based on their email. Is <u>not</u> case sensitive
     *
     * @param email the users email
     * @return the ID of the customer or -1 if no customer was found
     */
    @Override
    public int getCustomerIdFromEmail(String email) {
        try {
            ResultSet rs = databaseConnector.executeQuery(String.format("SELECT customerid FROM customer WHERE LOWER(email)='%s'", email.toLowerCase()));
            rs.next();
            return rs.getInt("customerid");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Saves a customer and it's information to the database
     *
     * @param customerID
     * @param name           The customers name
     * @param address        The customers physical address
     * @param email          The customers email
     * @param password       The customers hashed and salted password
     * @param birthday       The customers birthday. Is represented as an instant internally
     * @param phoneNumber    The customers phonenumber
     * @param passwordsalt   The salt for the customers password
     * @param currentorderid The ID of the customers current order
     */
    @Override
    public void saveCustomer(int customerID, String name, String address, String email, String password, Date birthday, int phoneNumber, String passwordsalt, int currentorderid) {
        if (emailExists(email)) {
            throw new IllegalArgumentException("Customer already exists");
        }

        try {
            databaseConnector.executeUpdate(String.format("INSERT INTO customer (customerid, name, address, email, password, birthday, phonenumber, passwordsalt, currentorderid) VALUES (%d, '%s', '%s', '%s', '%s', '%s', %d, '%s', %s)", customerID, name, address, email, password, birthday.toInstant(), phoneNumber, passwordsalt, "null"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calculate and returns the next available customerId
     *
     * @return The ID as an int. -1 if no ID available or if no database connection.
     */
    @Override
    public int getNextCustomerId() {
        try {
            ResultSet rs = databaseConnector.executeQuery("SELECT max(customerid) FROM customer");
            rs.next();
            return rs.getInt("max") + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Saves an order and it's information to the database
     *
     * @param orderId         The orders ID
     * @param customerId      The ID of the associated customer
     * @param finalPrice      The final price for the order, mainly used for closed orders
     * @param tax             The tax on the order
     * @param shippingCharges The shipping charges on the order
     * @param shippingAddress The shipping address of the customer
     * @param status          The status of the order currently
     * @param date            The date of the finalization of the order
     * @param items           A list of items in the order
     */
    @Override
    public void saveOrder(int orderId, int customerId, String finalPrice, String tax, String shippingCharges, String shippingAddress, String status, Date date, List<Item> items) {
        try {
            databaseConnector.executeUpdate(String.format("INSERT INTO orderinfo (orderid, customerid, finalprice, tax, shippingcharges, status, date) VALUES (%d, %d, %s, %s, '%s', %s, %s)", orderId, customerId, finalPrice, tax, shippingCharges, shippingAddress, status, date.toInstant()));
            for (Item item : items) {
                databaseConnector.executeUpdate(String.format("INSERT INTO productorderlink (productid, orderid, quantity) VALUES (%d, %d, %s)", item.getProduct().getID(), orderId, item.getQuantity()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a resultSet of productID's by searching for something where the type or name matches the input string. Uses partial matching
     *
     * @param searchTerms the type to match for
     * @return A ResultSet containing the information for the product(s)
     */
    @Override
    public ResultSet searchProduct(String searchTerms) {
        try {
            return databaseConnector.executeQuery(String.format("SELECT productid FROM product WHERE LOWER(type) like '%%%s%%' OR LOWER(name) like '%%%s%%'", searchTerms.toLowerCase(), searchTerms.toLowerCase()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NoSuchProductException();

    }

}
