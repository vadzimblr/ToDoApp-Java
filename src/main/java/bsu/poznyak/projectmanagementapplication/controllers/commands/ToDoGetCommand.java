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

public class ToDoGetCommand implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        IUserService userService = ServiceFactory.getUserService();
        var user_id = userService.GetUserIdByUsername(username);

        if (user_id.isEmpty()) {
            response.getWriter().write("User not found :( . Please try again");
            return;
        }
        ITaskService taskService = ServiceFactory.getTaskService();
        var tasks = taskService.GetAllTasks(user_id.get());
        request.setAttribute("tasks",tasks);
        request.getRequestDispatcher("/WEB-INF/views/to-do.jsp").forward(request, response);
    }
}
