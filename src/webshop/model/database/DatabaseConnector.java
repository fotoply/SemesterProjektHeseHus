package webshop.model.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseConnector {
    ResultSet executeQuery(String sqlQuery) throws SQLException;

    void executeUpdate(String sqlQuery) throws SQLException;

    boolean executeStatement(String sqlQuery) throws SQLException;

}
