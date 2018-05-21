package ru.innopolis.stc9.servlets.controller;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.pojo.User;
import ru.innopolis.stc9.servlets.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.sql.SQLException;

@WebServlet("/index")
public class StartServlet extends HttpServlet {
    private static final Logger logger = Logger.getRootLogger();
    private static final Logger errLogger = Logger.getLogger("errors");
    private UserService userService = new UserService();

    /*        String studName = req.getParameter("name");

        if (studName == null)
            return;
        List<User> students = studentService.getByName(studName);
        for (User student : students) {
            resp.getWriter().print(student.stud_id);
            resp.getWriter().println(' ' + student.name + ' ' + student.password);
        }*/


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("logout".equals(action)) {
            req.getSession().invalidate();
        }

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userName = req.getParameter("userName").trim();
        String password = req.getParameter("userPassword").trim();

        if (req.getParameter("button_login") != null){
            try {
                User user = userService.CheckAuthNameOrId(userName, password);
                if (user != null) {
                    req.getSession().setAttribute("user", user);
                    resp.sendRedirect(req.getContextPath() + "/inner/dashboard");
                } else {
                    resp.sendRedirect(req.getContextPath() + "/index?loginReply="
                            + "invalid password for name or ID");
                }
            } catch (SQLException e) {
                errLogger.error(e);
                resp.sendRedirect(req.getContextPath() + "/index?loginReply=" + e);
            }
        }else if (req.getParameter("button_add") != null){
            resp.sendRedirect(req.getContextPath() + "/index?loginReply="
                    + userAdd(userName, password));
        }
    }

    private String userAdd(String name, String password) {
        if (!name.isEmpty() && !password.isEmpty()) {
            try {
                int addRowCount = userService.addUser(name, password);
                if (addRowCount == 1) {
                    User user = userService.getByNamePasswordFirsResult(name, password);
                    String encodeUser = URLEncoder.encode('[' + user.getName() + ", id: " + user.getStud_id() + ']', "UTF-8");
                    return "user " + encodeUser + " has been registered, you can login";
                } else {
                    return "error: added " + addRowCount + " rows";
                }
            } catch (SQLException | UnsupportedEncodingException e) {
                errLogger.error(e);
                return e.toString();
            }
        } else {
            return "to add a new user enter a name and password";
        }
    }
}

