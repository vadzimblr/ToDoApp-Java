package bsu.poznyak.projectmanagementapplication.controllers.commands;

import bsu.poznyak.projectmanagementapplication.controllers.ICommand;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ToDoGetCommand implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/to-do.jsp").forward(request, response);
    }
}
