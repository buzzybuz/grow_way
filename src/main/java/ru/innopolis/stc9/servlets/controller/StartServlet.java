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

@WebServlet("/index")
public class StartServlet extends HttpServlet {
    private static final Logger logger = Logger.getRootLogger();
    private static final Logger errLogger = Logger.getLogger("errors");
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*        String studName = req.getParameter("name");

        if (studName == null)
            return;
        List<User> students = studentService.getByName(studName);
        for (User student : students) {
            resp.getWriter().print(student.stud_id);
            resp.getWriter().println(' ' + student.name + ' ' + student.password);
        }*/

        String action = req.getParameter("action");
        if ("logout".equals(action)) {
            req.getSession().invalidate();
        }

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userName = req.getParameter("userName");
        String password = req.getParameter("userPassword");

        if (req.getParameter("button_login") != null) {
            User user = userService.CheckAuthNameOrId(userName, password);
            if (user != null) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect(req.getContextPath() + "/student/somesheet");
            } else {
                resp.sendRedirect(req.getContextPath() + "/index?loginReply="
                        + "invalid password for name or ID");
            }
        } else if (req.getParameter("button_add") != null) {
            if (userName != "" && password != "") {
                String addResult = userService.addUser(userName, password);
                if (addResult == null) {
                    User user = userService.getByNamePasswordFirsResult(userName, password);
                    String encodeUser=URLEncoder.encode('['+userName+", id: "+user.stud_id+']' , "UTF-8");
                    resp.sendRedirect(req.getContextPath() + "/index?loginReply="
                            +"user "+encodeUser+" has been registered, you can login");
                } else {
                    resp.sendRedirect(req.getContextPath() + "/index?loginReply=" + addResult);
                }
            } else {
                resp.sendRedirect(req.getContextPath() + "/index?loginReply="
                        + "to add a new user enter a name and password");
            }
        }

    }
}

