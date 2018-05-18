package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    User getById(int id);
    User getByIdPassword(int id, String pass);
    List<User> getByName(String name);
    User getByNamePasswordFirsResult(String name, String pass);
    int addUser(String name, String password) throws SQLException;
}
