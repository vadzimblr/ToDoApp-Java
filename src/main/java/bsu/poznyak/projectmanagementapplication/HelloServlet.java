package bsu.poznyak.projectmanagementapplication;

import java.io.*;
import java.util.logging.Logger;

import bsu.poznyak.projectmanagementapplication.controllers.CommandFactory;
import bsu.poznyak.projectmanagementapplication.controllers.ICommand;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/controller")
public class HelloServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException("Failed to load JDBC driver.", e);
        }
    }
    private static final Logger LOGGER = Logger.getLogger(HelloServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action")+"_"+request.getMethod();
        LOGGER.info("Received action: " + action);

        ICommand command = CommandFactory.getCommand(action);

        if (command != null) {
            command.execute(request, response);
        } else {
            LOGGER.warning("Invalid command: " + action);
            response.getWriter().write("Invalid command");
        }
    }
}