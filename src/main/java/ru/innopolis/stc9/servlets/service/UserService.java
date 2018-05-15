package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.UserDAO;
import ru.innopolis.stc9.servlets.db.dao.UserDAOImpl;
import ru.innopolis.stc9.servlets.pojo.Student;

import java.util.List;

public class UserService {
    UserDAO userDAO = new UserDAOImpl();

    public Student getById(int id) {
        return userDAO.getById(id);
    }

    public Student getByIdPassword(int id, String pass) {
        return userDAO.getByIdPassword(id, pass);
    }

    public Student getByNamePasswordFirsResult(String name, String pass) {
        return userDAO.getByNamePasswordFirsResult(name, pass);
    }

    public List<Student> getByName(String name) {
        return userDAO.getByName(name);
    }

    public Student CheckAuthNameOrId(String name, String password){
        Student user=userDAO.getByNamePasswordFirsResult(name, password);
        if (user==null){
            try {
                int userId = Integer.parseInt(name);
                user=userDAO.getByIdPassword(userId, password);
            } catch (NumberFormatException e) { }
        }
        return user;
    }
}
