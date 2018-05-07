package ru.innopolis.stc9.servlets.db.dao;

import pojo.Lesson;

public interface LessonDAO {
    public int addLesson(Lesson lesson);
    public int updateLesson(Lesson lesson);
    public int deleteLesson(int num);
    public Lesson getLesson(int num);
}
