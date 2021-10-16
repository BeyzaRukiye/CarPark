package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    private static DBConnection instance;
    private Connection connection;

    private DBConnection() throws SQLException {
        try {
            Class.forName("org.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carparkSystem?user=root&password=123");
        } catch (ClassNotFoundException ex) {
            System.out.println("Veritabanı bağlantısı başarısız: " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DBConnection();
        }
        return instance;
    }

}
