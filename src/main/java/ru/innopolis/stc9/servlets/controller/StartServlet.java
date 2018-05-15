package ru.innopolis.stc9.servlets.controller;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.db.connection.ConnectionManagerJDBCImpl;
import ru.innopolis.stc9.servlets.pojo.Student;
import ru.innopolis.stc9.servlets.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

@WebServlet("/index")
public class StartServlet extends HttpServlet {
    private static final Logger logger = Logger.getRootLogger();
    private static final Logger errLogger = Logger.getLogger("errors");
    private UserService userService = new UserService();

    void getConnectionParams() {
        try {
            Properties property = new Properties();
            File dbLoginFile = new File(Thread.currentThread().getContextClassLoader().getResource(
                    "dbAuthorization.properties").toURI());
            property.load(new FileInputStream(dbLoginFile));

            ConnectionManagerJDBCImpl.DB_HOST = property.getProperty("DB.host");
            ConnectionManagerJDBCImpl.DB_LOGIN = property.getProperty("DB.login");
            ConnectionManagerJDBCImpl.DB_PASSWORD = property.getProperty("DB.password");
        } catch (Exception e) {
            errLogger.error(e);
            ConnectionManagerJDBCImpl.DB_HOST = "jdbc:postgresql://localhost:5432/University";
            ConnectionManagerJDBCImpl.DB_LOGIN = "UserName";
            ConnectionManagerJDBCImpl.DB_PASSWORD = "Password";
        }
    }

    @Override
    public void init() throws ServletException {
        getConnectionParams();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*        String studName = req.getParameter("name");

        if (studName == null)
            return;
        List<Student> students = studentService.getByName(studName);
        for (Student student : students) {
            resp.getWriter().print(student.stud_id);
            resp.getWriter().println(' ' + student.name + ' ' + student.password);
        }*/
        String action=req.getParameter("action");
        if("logout".equals(action)){
            req.getSession().invalidate();
        }
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("userPassword");

        Student user=userService.CheckAuthNameOrId(userName, password);
        if (user!=null){
            req.getSession().setAttribute("id", user.stud_id);
            req.getSession().setAttribute("name", user.name);
            req.getSession().setAttribute("role", user.role);
            resp.sendRedirect(req.getContextPath() + "/student/somesheet");
        }else{
            resp.sendRedirect(req.getContextPath() + "/index?loginReply="
                    + "invalid password for name or ID");
        }
    }
}

