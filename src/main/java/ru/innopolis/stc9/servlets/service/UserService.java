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
}
