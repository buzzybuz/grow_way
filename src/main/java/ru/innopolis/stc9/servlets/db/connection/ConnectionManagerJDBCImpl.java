package ru.innopolis.stc9.servlets.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerJDBCImpl implements ConnectionManager {
    private static ConnectionManager connectionManager;
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
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
