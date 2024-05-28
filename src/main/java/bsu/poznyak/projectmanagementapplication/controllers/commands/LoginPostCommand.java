package bsu.poznyak.projectmanagementapplication.controllers.commands;

import bsu.poznyak.projectmanagementapplication.controllers.ICommand;
import bsu.poznyak.projectmanagementapplication.services.IUserService;
import bsu.poznyak.projectmanagementapplication.services.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginPostCommand implements ICommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        IUserService userService = ServiceFactory.getUserService();
        if(userService.Login(username,password).isEmpty()){
            response.sendRedirect("controller?action=register");
            return;
        }
        else{
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
        }
        response.sendRedirect("controller?action=todo");
    }
}
