package ru.innopolis.stc9.servlets.service;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.db.dao.UserDAO;
import ru.innopolis.stc9.servlets.db.dao.UserDAOImpl;
import ru.innopolis.stc9.servlets.pojo.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    UserDAO userDAO = new UserDAOImpl();

    public User getById(int id) throws SQLException  {
        return userDAO.getById(id);
    }

    public User getByIdPassword(int id, String pass) throws SQLException  {
        return userDAO.getByIdPassword(id, pass);
    }

    public User getByNamePasswordFirsResult(String name, String pass) throws SQLException  {
        return userDAO.getByNamePasswordFirsResult(name, pass);
    }

    public List<User> getByName(String name) throws SQLException  {
        return userDAO.getByName(name);
    }

    public User CheckAuthNameOrId(String name, String password) throws SQLException {
        User user=userDAO.getByNamePasswordFirsResult(name, password);
        if (user==null){
            try {
                int userId = Integer.parseInt(name);
                user=userDAO.getByIdPassword(userId, password);
            } catch (NumberFormatException e) { }
        }
        return user;
    }

    public int addUser(String name, String password)throws SQLException {
        return userDAO.addUser(name, password);
    }
}
