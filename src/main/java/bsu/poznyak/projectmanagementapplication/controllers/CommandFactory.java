package bsu.poznyak.projectmanagementapplication.controllers;


import bsu.poznyak.projectmanagementapplication.controllers.commands.*;

public class CommandFactory {
    public static ICommand getCommand(String action) {
        if (action == null) {
            return null;
        }
        switch (action) {
            case "register_GET":
                return new RegisterGetCommand();
            case "register_POST":
                return new RegisterPostCommand();
            case "login_GET":
                return new LoginGetCommand();
            case "login_POST":
                return new LoginPostCommand();
            case "todo_GET":
                return new ToDoGetCommand();
            default:
                throw new IllegalArgumentException("No such command: " + action);
        }
    }
}
