package webshop.model.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseConnector {
    ResultSet executeQueryStatement(String sqlQuery) throws SQLException;
    void executeUpdateStatement(String sqlQuery) throws SQLException;
    boolean executeStatement(String sqlQuery) throws SQLException;

}
