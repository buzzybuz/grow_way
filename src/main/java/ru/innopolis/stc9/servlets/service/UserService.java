package ru.innopolis.stc9.servlets.service;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.db.dao.UserDAO;
import ru.innopolis.stc9.servlets.db.dao.UserDAOImpl;
import ru.innopolis.stc9.servlets.pojo.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    UserDAO userDAO = new UserDAOImpl();

    public User getById(int id) {
        return userDAO.getById(id);
    }

    public User getByIdPassword(int id, String pass) {
        return userDAO.getByIdPassword(id, pass);
    }

    public User getByNamePasswordFirsResult(String name, String pass) {
        return userDAO.getByNamePasswordFirsResult(name, pass);
    }

    public List<User> getByName(String name) {
        return userDAO.getByName(name);
    }

    public User CheckAuthNameOrId(String name, String password){
        User user=userDAO.getByNamePasswordFirsResult(name, password);
        if (user==null){
            try {
                int userId = Integer.parseInt(name);
                user=userDAO.getByIdPassword(userId, password);
            } catch (NumberFormatException e) { }
        }
        return user;
    }

    public String addUser(String name, String password) {
        String result=null;
        try{
            userDAO.addUser(name, password);
        } catch (SQLException e) {
            result=e.toString();
        }
        return result;
    }
}
