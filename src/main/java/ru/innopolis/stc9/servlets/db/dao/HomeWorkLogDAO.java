package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.HomeWorkLog;

import java.util.List;

public interface HomeWorkLogDAO {
    public int addHomeWorkLog(HomeWorkLog homeWorkLog);
    public int updateById(HomeWorkLog homeWorkLog);
    public int updateByWorkAndStud(int work_id, int stud_id, byte progress, byte assessment);  // and/or
    public int deleteById(int id);
    public int deleteByWorkAndStud(int work_id, int stud_id);                  // and/or
    public HomeWorkLog getById(int id);
    public List<HomeWorkLog> getByWorkAndStud(int work_id, int stud_id);  // and/or
}
