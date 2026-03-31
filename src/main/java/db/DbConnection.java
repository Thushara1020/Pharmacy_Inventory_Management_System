package db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simple singleton DB connection. Reads credentials from /config.properties when available.
 * If the properties file is missing, falls back to reasonable defaults (localhost, root, empty password).
 */
public class DbConnection {

    private static final Logger LOGGER = Logger.getLogger(DbConnection.class.getName());

    private static DbConnection instance;

    private final Connection connection;

    private DbConnection() throws SQLException {
        Properties props = new Properties();
        String url = "jdbc:mysql://localhost:3306/pharmacy_db";
        String user = "root";
        String pass = "";

        try (InputStream is = getClass().getResourceAsStream("/config.properties")) {
            if (is != null) {
                props.load(is);
                url = props.getProperty("db.url", url);
                user = props.getProperty("db.user", user);
                pass = props.getProperty("db.password", pass);
            }
        } catch (IOException e) {
            // If properties can't be loaded, continue with defaults but log a warning.
            LOGGER.log(Level.WARNING, "Could not load config.properties", e);
        }

        connection = DriverManager.getConnection(url, user, pass);
    }

    public static DbConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}