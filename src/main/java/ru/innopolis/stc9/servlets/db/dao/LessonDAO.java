package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.Lesson;

import java.sql.SQLException;
import java.util.List;

public interface LessonDAO {
    public int addLesson(Lesson lesson)throws SQLException;
    public int updateLesson(Lesson lesson)throws SQLException;
    public int deleteLesson(int num)throws SQLException;
    public Lesson getLesson(int num)throws SQLException;
    public List<Lesson> getAll() throws SQLException;
}
