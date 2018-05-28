package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.db.connection.ConnectionManager;
import ru.innopolis.stc9.servlets.db.connection.ConnectionManagerJDBCImpl;
import ru.innopolis.stc9.servlets.pojo.Lesson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LessonDAOImpl implements LessonDAO {
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();

    @Override
    public int addLesson(Lesson lesson) throws SQLException {
        return 0;
    }

    @Override
    public int updateLesson(Lesson lesson) throws SQLException {
        return 0;
    }

    @Override
    public int deleteLesson(int num) throws SQLException {
        return 0;
    }

    @Override
    public Lesson getLesson(int num) throws SQLException {
        return null;
    }

    @Override
    public List<Lesson> getAll() throws SQLException {
        ArrayList<Lesson> result = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM \"Lessons\"")) {
            while (resultSet.next()) {
                result.add(new Lesson(
                        resultSet.getInt(1),
                        resultSet.getTimestamp(2),
                        resultSet.getString(3)
                ));
            }
        }
        return result;
    }
}
