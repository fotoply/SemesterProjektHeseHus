package webshop.model;

import webshop.model.Inventory.PostgresDatabaseOrder;
import webshop.model.database.DatabaseConnector;
import webshop.model.database.PostgresConnectionDriver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PostgresDatabaseCustomer extends Customer {

    PostgresConnectionDriver connectionDriver;

    public PostgresDatabaseCustomer(DatabaseConnector connector) {
        super();
        this.connectionDriver = (PostgresConnectionDriver) connector;
    }

    public PostgresDatabaseCustomer(DatabaseConnector connector, int customerId) {
        this(connector);
        try {
            ResultSet rs = connectionDriver.executeQuery("SELECT * FROM customer WHERE customerid=" + customerId);
            if(rs.next()) {
                setName(rs.getString("name"));
                setAddress(rs.getString("address"));
                setBirthday(rs.getDate("birthday"));
                setCurrentOrder(new PostgresDatabaseOrder(connectionDriver, rs.getInt("currentorderid")));
                setEmail(rs.getString("email"));
                setPassword(Customer.fromBase64(rs.getString("password")));
                setSalt(Customer.fromBase64(rs.getString("passwordsalt")));
                setPhoneNumber(rs.getInt("phonenumber"));
            } else {
                throw new IllegalArgumentException("Customer does not exist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PostgresDatabaseCustomer(String name, String address, String email, String password, Date dayOfBirth, int phoneNumber, PostgresConnectionDriver connectionDriver) {
        super(name, address, email, password, dayOfBirth, phoneNumber);
        this.connectionDriver = connectionDriver;
        int id = -1;
        try {
            ResultSet rs = connectionDriver.executeQuery("SELECT max(customerid) FORM customer");
            id = rs.getInt("customerid") + 1;

            connectionDriver.executeUpdate(String.format("INSERT INTO customer (customerid, name, address, email, password, birthday, phonenumber, passwordsalt, currentorder) VALUES (%d, '%s', '%s', '%s', '%s', '%s', %d, '%s', %d)", id, name, address, email, Customer.toBase64(getPassword()), dayOfBirth.toInstant(), phoneNumber, Customer.toBase64(getSalt()), -1));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
