package webshop.model;

import webshop.model.database.DatabaseConnector;
import webshop.model.database.PostgresConnectionDriver;

import java.util.Date;

public class PostgresDatabaseCustomer extends Customer {

    PostgresConnectionDriver connectionDriver;

    public PostgresDatabaseCustomer(DatabaseConnector connector) {
        super();
        this.connectionDriver = (PostgresConnectionDriver) connector;
    }

    public PostgresDatabaseCustomer(String name, String address, String email, String password, Date dayOfBirth, int phoneNumber, PostgresConnectionDriver connectionDriver) {
        super(name, address, email, password, dayOfBirth, phoneNumber);
        this.connectionDriver = connectionDriver;


    }
}
