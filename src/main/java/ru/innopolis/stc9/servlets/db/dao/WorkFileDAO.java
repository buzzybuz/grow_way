package ru.innopolis.stc9.servlets.db.dao;

import pojo.WorkFile;

import java.util.List;

public interface WorkFileDAO {
    public int addWorkFile(WorkFile workFile);
    public int updateById(int id, String file_path);
    public int updateByWorklog(int worklog_id, String file_path);
    public int deleteById(int id);
    public int deleteByWorklog(int worklog_id);
    public WorkFile getWorkFileById(int id);
    public List<WorkFile> getWorkFileByWorklog(int worklog_id);

}
