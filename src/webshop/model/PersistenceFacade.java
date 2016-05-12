package webshop.model;

import webshop.model.database.DatabaseFacade;

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

    public Customer getFromId(int customerId) {
        ResultSet rs = database.getCustomer(customerId);
        Customer newCustomer = null;
        try {
            if (rs.next()) {
                newCustomer = new Customer(rs.getString("name"), rs.getString("address"), rs.getString("email"), "toBeLoaded", rs.getDate("birthday"), rs.getInt("phonenumber"));
                newCustomer.setPassword(Customer.fromBase64(rs.getString("password")));
                newCustomer.setSalt(Customer.fromBase64(rs.getString("passwordsalt")));
                //setCurrentOrder(new PostgresDatabaseOrder(connectionDriver, rs.getInt("currentorderid")));
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
}
