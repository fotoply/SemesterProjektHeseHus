package webshop.model.database;

import java.sql.ResultSet;

public interface DatabaseConnector {
    ResultSet executeQueryStatement(String sqlQuery);
    void executeUpdateStatement(String sqlQuery);
    boolean excuteStatement(String sqlQuery);

}
