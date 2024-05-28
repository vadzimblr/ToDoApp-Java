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
import java.time.format.DateTimeFormatter;

public class EditTaskPostCommand implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        String oldDeadlineStr = request.getParameter("oldDeadline");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        LocalDateTime oldLocalDateTime;
        try {
            oldLocalDateTime = LocalDateTime.parse(oldDeadlineStr, formatter);
        } catch (Exception e) {
            response.getWriter().write("Invalid old deadline format. Please try again.");
            return;
        }
        Timestamp oldDeadline = Timestamp.valueOf(oldLocalDateTime);

        String deadlineStr = request.getParameter("deadline");
        LocalDateTime localDateTime;
        Timestamp deadline;
        if (deadlineStr == null || deadlineStr.isEmpty()) {
            deadline = null;
        } else {
            try {
                localDateTime = LocalDateTime.parse(deadlineStr);
                deadline = Timestamp.valueOf(localDateTime);
            } catch (Exception e) {
                response.getWriter().write("Invalid deadline format. Please provide a valid deadline.");
                return;
            }
        }

        Timestamp resultingDeadline = oldDeadline;
        if (deadline != null && deadline.after(oldDeadline)) {
            resultingDeadline = deadline;
        }

        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        IUserService userService = ServiceFactory.getUserService();
        var user_id = userService.GetUserIdByUsername(username);

        if (user_id.isEmpty()) {
            response.getWriter().write("User not found :( . Please try again");
            return;
        }

        ITaskService taskService = ServiceFactory.getTaskService();
        taskService.UpdateTask(title,description,resultingDeadline,taskId,user_id.get());
        response.sendRedirect("controller?action=todo");
    }
}
