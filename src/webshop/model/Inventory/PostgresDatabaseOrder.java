package webshop.model.Inventory;

import webshop.model.database.DatabaseConnector;
import webshop.model.database.PostgresConnectionDriver;

import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 * Created 5/4/16
 *
 * @author Niels Norberg
 */
public class PostgresDatabaseOrder extends Order {
    DatabaseConnector connector;

    public PostgresDatabaseOrder(PostgresConnectionDriver driver, int orderId) throws SQLException {
        super(orderId);
        this.connector = driver;
        ResultSet rs = driver.executeQueryStatement("SELECT * FROM order WHERE orderId=" + orderId);
        if (rs.next()) {
            if (!rs.getString("tax").isEmpty()) {

            }
        } else {
            throw new SQLDataException("Order not found");
        }
    }
}
