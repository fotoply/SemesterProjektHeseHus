package webshop.model.Inventory;

import webshop.model.Money;
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

        if (rs.next()) {
            if (!rs.getString("tax").isEmpty()) {
                setTax(new Money(rs.getString("tax")));
                setFinalPrice(new Money(rs.getString("finalprice")));
                setShippingCharges(new Money(rs.getString("shippingcharges")));
                setStatus(Status.CLOSED);
            }
            setCustomerID(rs.getInt("customerid"));
            setShippingAddress(rs.getString("shippingaddress"));
            setDate(rs.getDate("date"));
            ResultSet rs2 = driver.executeQuery("SELECT * FROM productorderlink where orderid=" + orderId);
            while(rs2.next()) {
                addProduct(new PostgresDatabaseProduct(driver, rs2.getInt("productid")), rs2.getInt("quantity"));
            }
        } else {
            throw new SQLDataException("Order not found");
        }
    }
}
