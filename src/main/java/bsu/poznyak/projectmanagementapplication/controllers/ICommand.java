package bsu.poznyak.projectmanagementapplication.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ICommand {
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
