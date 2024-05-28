package bsu.poznyak.projectmanagementapplication.controllers.commands;

import bsu.poznyak.projectmanagementapplication.controllers.ICommand;
import bsu.poznyak.projectmanagementapplication.services.ITaskService;
import bsu.poznyak.projectmanagementapplication.services.IUserService;
import bsu.poznyak.projectmanagementapplication.services.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CreateTaskPostCommand implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String deadlineStr = request.getParameter("deadline");

        LocalDateTime localDateTime = LocalDateTime.parse(deadlineStr);
        Timestamp deadline = Timestamp.valueOf(localDateTime);

        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        IUserService userService = ServiceFactory.getUserService();
        var user_id = userService.GetUserIdByUsername(username);

        if (user_id.isEmpty()) {
            response.getWriter().write("User not found :( . Please try again");
            return;
        }

        ITaskService taskService = ServiceFactory.getTaskService();
        var result = taskService.CreateTask(title, description, deadline, user_id.get());

        if (result.isEmpty()) {
            response.getWriter().write("Something went wrong :( . Please try again");
            return;
        }

        response.sendRedirect("controller?action=todo");
    }
}
