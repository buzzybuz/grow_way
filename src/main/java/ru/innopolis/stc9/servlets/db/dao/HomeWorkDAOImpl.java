package ru.innopolis.stc9.servlets.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.db.connection.ConnectionManager;
import ru.innopolis.stc9.servlets.db.connection.ConnectionManagerJDBCImpl;
import ru.innopolis.stc9.servlets.pojo.HomeWork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeWorkDAOImpl implements HomeWorkDAO {
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();
    private static final Logger errLogger = Logger.getLogger("errors");

    @Override
    public int addHomeWork(HomeWork homeWork) {
        int result = -1;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO \"HomeWork\" VALUES (default, ?, ?, ?)");
            ps.setInt(1, homeWork.num);
            ps.setString(2, homeWork.task_text);
            ps.setTimestamp(3, homeWork.deadline);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            errLogger.error(e);
        }
        return result;
    }

    @Override
    public int updateById(HomeWork homeWork) {
        int result = -1;
        try (Connection connection = connectionManager.getConnection()) {
            if (homeWork.task_text != null && homeWork.deadline != null) {
                PreparedStatement ps = connection.prepareStatement(
                        "UPDATE \"HomeWork\" SET task_text= ?, deadline= ? WHERE work_id= ?");
                ps.setString(1, homeWork.task_text);
                ps.setTimestamp(2, homeWork.deadline);
                ps.setInt(3, homeWork.work_id);
                result = ps.executeUpdate();
            } else if (homeWork.task_text != null) {
                PreparedStatement ps = connection.prepareStatement(
                        "UPDATE \"HomeWork\" SET task_text= ? WHERE work_id= ?");
                ps.setString(1, homeWork.task_text);
                ps.setInt(2, homeWork.work_id);
                result = ps.executeUpdate();
            } else if (homeWork.deadline != null) {
                PreparedStatement ps = connection.prepareStatement(
                        "UPDATE \"HomeWork\" SET deadline= ? WHERE work_id= ?");
                ps.setTimestamp(1, homeWork.deadline);
                ps.setInt(2, homeWork.work_id);
                result = ps.executeUpdate();
            }
        } catch (SQLException e) {
            errLogger.error(e);
        }
        return result;
    }

    @Override
    public int updateByNumber(HomeWork homeWork) {
        int result = -1;
        try (Connection connection = connectionManager.getConnection()) {
            if (homeWork.task_text != null && homeWork.deadline != null) {
                PreparedStatement ps = connection.prepareStatement(
                        "UPDATE \"HomeWork\" SET task_text= ?, deadline= ? WHERE number= ?");
                ps.setString(1, homeWork.task_text);
                ps.setTimestamp(2, homeWork.deadline);
                ps.setInt(3, homeWork.num);
                result = ps.executeUpdate();
            } else if (homeWork.task_text != null) {
                PreparedStatement ps = connection.prepareStatement(
                        "UPDATE \"HomeWork\" SET task_text= ? WHERE number= ?");
                ps.setString(1, homeWork.task_text);
                ps.setInt(2, homeWork.num);
                result = ps.executeUpdate();
            } else if (homeWork.deadline != null) {
                PreparedStatement ps = connection.prepareStatement(
                        "UPDATE \"HomeWork\" SET deadline= ? WHERE number= ?");
                ps.setTimestamp(1, homeWork.deadline);
                ps.setInt(2, homeWork.num);
                result = ps.executeUpdate();
            }
        } catch (SQLException e) {
            errLogger.error(e);
        }
        return result;
    }

    @Override
    public int deleteById(int id) {
        int result = -1;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM \"HomeWork\" WHERE work_id= ?");
            ps.setInt(1, id);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            errLogger.error(e);
        }
        return result;
    }

    @Override
    public int deleteByNumber(int num) {
        int result = -1;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM \"HomeWork\" WHERE work_id = ?");
            ps.setInt(1, num);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            errLogger.error(e);
        }
        return result;
    }

    @Override
    public HomeWork getRowById(int id) {
        HomeWork result=null;
        try (Connection connection=connectionManager.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM \"HomeWork\" WHERE work_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            result=new HomeWork(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getTimestamp(4)
            );
        } catch (SQLException e) {
            errLogger.error(e);
        }
        return result;
    }

    @Override
    public List<HomeWork> getRowsByNumber(int num) {
        ArrayList<HomeWork> result=new ArrayList<>();
        try (Connection connection=connectionManager.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM \"HomeWork\" WHERE number = ?");
            statement.setInt(1, num);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(new HomeWork(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getTimestamp(4)
                ));
            }
        } catch (SQLException e) {
            errLogger.error(e);
        }
        return result;
    }
}
