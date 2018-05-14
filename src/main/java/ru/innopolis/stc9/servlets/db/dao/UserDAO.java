package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.Student;

import java.util.List;

public interface UserDAO {
    Student getById(int id);
    Student getByIdPassword(int id, String pass);
    List<Student> getByName(String name);
    Student getByNamePasswordFirsResult(String name, String pass);
}
