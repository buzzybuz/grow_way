package ru.innopolis.stc9.servlets.db.connection;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerJDBCImpl implements ConnectionManager {
    private static ConnectionManager connectionManager;
    private static final Logger errLogger = Logger.getLogger("errors");
    public static String DB_HOST;
    public static String DB_LOGIN;
    public static String DB_PASSWORD;

    public static ConnectionManager getInstance(){
        if(connectionManager==null)
            connectionManager=new ConnectionManagerJDBCImpl();
        return connectionManager;
    }

    private ConnectionManagerJDBCImpl(){}

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
