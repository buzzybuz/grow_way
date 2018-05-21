package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    User getById(int id) throws SQLException;
    User getByIdPassword(int id, String pass) throws SQLException;
    List<User> getByName(String name) throws SQLException;
    User getByNamePasswordFirsResult(String name, String pass) throws SQLException;
    int addUser(String name, String password) throws SQLException;
}
