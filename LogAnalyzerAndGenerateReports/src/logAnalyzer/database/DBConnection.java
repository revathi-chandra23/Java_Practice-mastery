

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/logdb";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "Revathi@2002";
    public static Connection getConnection()
            throws ClassNotFoundException,
            SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}