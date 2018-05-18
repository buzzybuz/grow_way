package ru.innopolis.stc9.servlets.db.connection;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManagerJDBCImpl implements ConnectionManager {
    private static ConnectionManager connectionManager;
    private static final Logger errLogger = Logger.getLogger("errors");
    private static String DB_HOST;
    private static String DB_LOGIN;
    private static String DB_PASSWORD;

    public static ConnectionManager getInstance(){
        if(connectionManager==null)
            connectionManager=new ConnectionManagerJDBCImpl();
        return connectionManager;
    }

    void getConnectionParams() {
        try {
            Properties property = new Properties();
            File dbLoginFile = new File(Thread.currentThread().getContextClassLoader().getResource(
                    "dbAuthorization.properties").toURI());
            property.load(new FileInputStream(dbLoginFile));

            DB_HOST = property.getProperty("DB.host");
            DB_LOGIN = property.getProperty("DB.login");
            DB_PASSWORD = property.getProperty("DB.password");
        } catch (Exception e) {
            errLogger.error(e);
            DB_HOST = "jdbc:postgresql://localhost:5432/University";
            DB_LOGIN = "UserName";
            DB_PASSWORD = "Password";
        }
    }

    private ConnectionManagerJDBCImpl(){
        getConnectionParams();
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_HOST, DB_LOGIN, DB_PASSWORD);
        } catch (SQLException e) {
            errLogger.error(e);
        } catch (ClassNotFoundException e) {
            errLogger.error(e);
        }
        return connection;
    }
}
