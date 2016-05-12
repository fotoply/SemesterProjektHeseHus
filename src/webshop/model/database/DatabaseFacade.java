package webshop.model.database;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseFacade {

    private static DatabaseConnector databaseConnector = new PostgresConnectionDriver();
    private static DatabaseFacade instance;

    private DatabaseFacade() {
        databaseConnector.getConnection();
    }

    public static DatabaseFacade getInstance() {
        if(instance == null) {
            instance = new DatabaseFacade();
        }
        return instance;
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
        throw new NotImplementedException();
    }

    public ResultSet getOrder(int orderId) {
        throw new NotImplementedException();
    }

    public int getCustomerIdFromEmail(String email) {
        throw new NotImplementedException();
    }
}
