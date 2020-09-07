
package dev.manhnx.dal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/coffeeshop";
    private static String user = "root";
    private static String password = "123456789";

    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        return connection;

    }

}