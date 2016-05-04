package webshop.model.Inventory;

import webshop.model.database.DatabaseConnector;
import webshop.model.database.PostgresConnectionDriver;

/**
 * Created 5/4/16
 *
 * @author Niels Norberg
 */
public class PostgresDatabaseOrder extends Order {
    DatabaseConnector connector;

    public PostgresDatabaseOrder(PostgresConnectionDriver driver, int orderId) {
        super(orderId);
        this.connector = driver;

    }
}
