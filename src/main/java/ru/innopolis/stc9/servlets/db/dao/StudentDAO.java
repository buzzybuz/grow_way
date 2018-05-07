package ru.innopolis.stc9.servlets.db.dao;

import pojo.Student;

import java.util.List;

public interface StudentDAO {
    public int addStudent(Student student);
    public int updateById(Student student);
    public int updateByName(String name, String password);
    public int deleteById(int id);
    public int deleteByName(String name);
    public Student getById(int id);
    public List<Student> getByName(String name);
}
