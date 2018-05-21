package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.LessonDAO;
import ru.innopolis.stc9.servlets.db.dao.LessonDAOImpl;
import ru.innopolis.stc9.servlets.pojo.Lesson;

import java.sql.SQLException;
import java.util.List;

public class LessonService {
    LessonDAO lessonDAO=new LessonDAOImpl();

    public List<Lesson> getAll() throws SQLException{
        return lessonDAO.getAll();
    }
}
