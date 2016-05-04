package webshop.model.Inventory;

import webshop.model.Money;
import webshop.model.database.DatabaseConnector;
import webshop.model.database.PostgresConnectionDriver;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created 5/4/16
 *
 * @author Niels Norberg
 */
public class PostgresDatabaseProduct extends Product {

    DatabaseConnector databaseConnector;

    public PostgresDatabaseProduct(PostgresConnectionDriver connector, int productId) throws SQLException {
        super(productId);
        databaseConnector = connector;
        ResultSet rs = databaseConnector.executeQueryStatement("SELECT * FROM product WHERE productId=" + getProductID());
        if (rs.next()) {
            setName(rs.getString("name"));
            setDescription(rs.getString("description"));
            setPrice(new Money(rs.getString("price")));
            setType(rs.getString("type"));
            setCurrentlySelling(rs.getBoolean("currentlySelling"));
        } else {
            throw new SQLException("Product not found");
        }
    }
}
