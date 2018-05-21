package ru.innopolis.stc9.servlets.controller;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.service.LessonService;
import ru.innopolis.stc9.servlets.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/inner/schedule")
public class ScheduleController extends HttpServlet {
    private static final Logger errLogger = Logger.getLogger("errors");
    private LessonService lessonService = new LessonService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            req.setAttribute("scheduleList", lessonService.getAll());
        } catch (SQLException e) {
            errLogger.error(e);
            req.setAttribute("err", e);
        }
        req.getRequestDispatcher("/schedule.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
