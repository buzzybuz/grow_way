package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.HomeWork;

import java.util.List;

public interface HomeWorkDAO {
    public int addHomeWork(HomeWork homeWork);
    public int updateById(HomeWork homeWork);
    public int updateByNumber(HomeWork homeWork);
    public int deleteById(int id);
    public int deleteByNumber(int num);
    public HomeWork getRowById(int id);
    public List<HomeWork> getRowsByNumber(int num);
}
