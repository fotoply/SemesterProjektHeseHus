package webshop.model.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class PostgresConnectionDriver implements DatabaseConnector {
    private String defaultInfoFile = "logininfo.txt";
    private final String defaultUsername = "postgres";
    private final String defaultPassword = "123";
    private final String defaultUrl = "jdbc:postgresql://localhost:5432/hesehus";

    private String username;
    private String password;
    private String url;

    private Connection connection;

    public void connect() {
        readInfofile();
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

    private void readInfofile() {
        try (Scanner scanner = new Scanner(new File(defaultInfoFile))){
            String[] input = scanner.nextLine().split(";");
            username = input[0];
            password = input[1];
            url = input[2];
        } catch (FileNotFoundException e) {
            System.out.println("An error was encountered, file not found, using defaults");
            username = defaultUsername;
            password = defaultPassword;
            url = defaultUrl;
        }
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
