package webshop.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DatabaseFacade {

    private static DatabaseConnector databaseConnector = new PostgresConnectionDriver();
    private static DatabaseFacade instance;

    private DatabaseFacade() {
        databaseConnector.getConnection();
    }

    public static DatabaseFacade getInstance() {
        initializeConnection();
        return instance;
    }

    public static void initializeConnection() {
        if (instance == null) {
            instance = new DatabaseFacade();
        }
    }

    public boolean emailExists(String email) {
        ResultSet rs = null;
        try {
            rs = databaseConnector.executeQuery("SELECT email FROM customer WHERE email='" + email.toLowerCase() + "'");
            return rs.isBeforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();


        }
        throw new RuntimeException("Something went wrong in executing SQL statement.");

    }

    public ResultSet getCustomer(int customerId) {
        try {
            return databaseConnector.executeQuery("SELECT * FROM customer WHERE customerid=" + customerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Something went wrong in executing SQL statement.");
    }

    public ResultSet getProduct(int productId) {
        try {
            return databaseConnector.executeQuery("SELECT * FROM product WHERE productId=" + productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Something went wrong in executing SQL statement.");
    }

    public ResultSet getOrder(int orderId) {
        try {
            return databaseConnector.executeQuery("SELECT * FROM orderinfo WHERE orderId=" + orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Something went wrong in executing SQL statement.");
    }

    public int getCustomerIdFromEmail(String email) {
        try {
            ResultSet rs = databaseConnector.executeQuery(String.format("SELECT costumerid FROM customer WHERE email='%s'", email));
            return rs.getInt("customerid");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void saveCustomer(String name, String address, String email, String password, Date birthday, int phoneNumber, String passwordsalt, int currentorderid) {
        if (emailExists(email)) {
            throw new IllegalArgumentException("Customer already exists");
        }
        int id = -1;
        try {
            ResultSet rs = databaseConnector.executeQuery("SELECT max(customerid) FROM customer");
            id = rs.getInt("customerid") + 1;

            databaseConnector.executeUpdate(String.format("INSERT INTO customer (customerid, name, address, email, password, birthday, phonenumber, passwordsalt, currentorderid) VALUES (%d, '%s', '%s', '%s', '%s', '%s', %d, '%s', %d)", id, name, address, email, password, birthday.toInstant(), phoneNumber, passwordsalt, -1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveOrder(int orderId, int customerId, String finalPrice, String tax, String shippingCharges, String shippingAddress, String status, Date date) {
        //TODO Implement saving of orders.
    }

    public ResultSet getProductByType(String searchTerms) {
        try {
            return databaseConnector.executeQuery("SELECT * FROM product WHERE type like " + searchTerms + "%");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Something went wrong in executing SQL statement.");

    }

    public ResultSet getProductByName(String searchTerms) {
        try {
            return databaseConnector.executeQuery("SELECT * FROM product WHERE name=" + searchTerms + "%");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Something went wrong in executing SQL statement.");
    }
}
