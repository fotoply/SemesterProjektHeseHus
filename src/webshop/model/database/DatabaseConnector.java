package webshop.model.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseConnector {
    Connection getConnection();

    ResultSet executeQuery(String sqlQuery) throws SQLException;

    void executeUpdate(String sqlQuery) throws SQLException;

    boolean executeStatement(String sqlQuery) throws SQLException;

}
