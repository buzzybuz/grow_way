package ru.innopolis.stc9.servlets.db.dao;

import pojo.LessonLog;

import java.util.List;

public interface LessonLogDAO {
    public int addLessonLog(LessonLog lessonLog);
    public int updateById(LessonLog lessonLog);
    public int updateByNumberAndStud(int num, int stud_id, Boolean presence);
    public int deleteById(int id);
    public int deleteByNumberAndStud(int num, int stud_id);
    public LessonLog getById(int id);
    public List<LessonLog> getByNumberAndStud(int num, int stud_id);
}
