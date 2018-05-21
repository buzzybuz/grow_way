package ru.innopolis.stc9.servlets.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.db.connection.ConnectionManager;
import ru.innopolis.stc9.servlets.db.connection.ConnectionManagerJDBCImpl;
import ru.innopolis.stc9.servlets.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();

    @Override
    public User getById(int id) throws SQLException{
        User result = null;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT user_id, name, role FROM \"Users\" WHERE user_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                result = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getByte(3)
                );
            }
        }
        return result;
    }

    public User getByIdPassword(int id, String pass) throws SQLException {
        User result = null;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT user_id, name, role FROM \"Users\" WHERE user_id = ? AND password = ?");
            statement.setInt(1, id);
            statement.setString(2, pass);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                result = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getByte(3)
                );
            }
        }
        return result;
    }

    @Override
    public User getByNamePasswordFirsResult(String name, String pass) throws SQLException {
        User result = null;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT user_id, name, role FROM \"Users\" WHERE name = ? AND password = ?");
            statement.setString(1, name);
            statement.setString(2, pass);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                result = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getByte(3)
                );
            }
        }
        return result;
    }

    @Override
    public List<User> getByName(String name) throws SQLException {
        ArrayList<User> result = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT user_id, name, role FROM \"Users\" WHERE name = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getByte(3)
                ));
            }
        }
        return result;
    }


    @Override
    public int addUser(String name, String password) throws SQLException {
        int result = -1;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO \"Users\" (name, password) VALUES (?, ?)");
            ps.setString(1, name);
            ps.setString(2, password);
            result = ps.executeUpdate();
        }
        return result;
    }
}
