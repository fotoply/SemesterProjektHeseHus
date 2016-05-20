package webshop.database;

import java.sql.*;

public interface DatabaseConnector {
    Connection getConnection();

    ResultSet executeQuery(String sqlQuery) throws SQLException;

    void executeUpdate(String sqlQuery) throws SQLException;

    boolean executeStatement(String sqlQuery) throws SQLException;

}
