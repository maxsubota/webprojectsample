package by.subota.max.controller;

import by.subota.max.controller.command.Command;
import by.subota.max.controller.command.CommandProvider;
import by.subota.max.dto.ResponseContent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(/* Provide your code here**/)
public class AjaxController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = CommandProvider.getInstance().takeCommand("CommandExample");
        ResponseContent responseContent = command.execute(request);

        // Provide your code here

    }
}
