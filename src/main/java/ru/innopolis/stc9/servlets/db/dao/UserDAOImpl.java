package ru.innopolis.stc9.servlets.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.db.connection.ConnectionManager;
import ru.innopolis.stc9.servlets.db.connection.ConnectionManagerJDBCImpl;
import ru.innopolis.stc9.servlets.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();
    private static final Logger logger = Logger.getRootLogger();
    private static final Logger errLogger = Logger.getLogger("errors");

    @Override
    public Student getById(int id) {
        Student result = null;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM \"Users\" WHERE user_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                result = new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getByte(4)
                );
            }
        } catch (SQLException e) {
            errLogger.error(e);
        }
        return result;
    }

    public Student getByIdPassword(int id, String pass) {
        Student result = null;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM \"Users\" WHERE user_id = ? AND password = ?");
            statement.setInt(1, id);
            statement.setString(2, pass);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                result = new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getByte(4)
                );
            }
        } catch (SQLException e) {
            errLogger.error(e);
        }
        return result;
    }

    @Override
    public Student getByNamePasswordFirsResult(String name, String pass) {
        Student result = null;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM \"Users\" WHERE name = ? AND password = ?");
            statement.setString(1, name);
            statement.setString(2, pass);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                result = new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getByte(4)
                );
            }
        } catch (SQLException e) {
            errLogger.error(e);
        }
        return result;
    }

    @Override
    public List<Student> getByName(String name) {
        ArrayList<Student> result = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM \"Users\" WHERE name = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getByte(4)
                ));
            }
        } catch (SQLException e) {
            errLogger.error(e);
        }
        return result;
    }
}
