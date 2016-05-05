package webshop.model.database;

import java.sql.*;

public class PostgresConnectionDriver implements DatabaseConnector {
    private String username = "postgres";
    private String password = "123";
    private String url = "jdbc:postgresql://localhost:5432/testdb";
    private Connection connection;

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public Connection getConnection() {
        if (connection == null) {
            connect();
        }
        return connection;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public ResultSet executeQuery(String sqlQuery) throws SQLException {
        Statement statement = connection.createStatement();
        statement.closeOnCompletion();
        return statement.executeQuery(sqlQuery);
    }

    @Override
    public void executeUpdate(String sqlQuery) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlQuery);
        statement.close();
    }

    @Override
    public boolean executeStatement(String sqlQuery) throws SQLException {
        Statement statement = connection.createStatement();
        statement.closeOnCompletion();
        return statement.execute(sqlQuery);
    }
}
