/*package com.simiosMeli.dataBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            try {


                Properties properties = loadProperties();
                String url = properties.getProperty("dburl");
                connection = DriverManager.getConnection(url, properties);
            }
            catch (SQLException error) {
                throw new DbException(error.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection () {
        if (connection != null) {
            try {
                connection.close();
            }
            catch (SQLException error) {
                throw new DbException(error.getMessage());
            }
        }
    }

    private  static Properties loadProperties() {
        try (FileInputStream fileInputStream = new FileInputStream("db.properties")){
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        }
        catch (IOException error) {
            throw new DbException(error.getMessage());
        }
    }
}
*/