package com.example.demo.servlets;


import com.example.demo.repository.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.sql.SQLException;


/**
 * Author : Evgeniy Nechaev.
 * Created : 06/12/2022.
 * Servlet RemovePanel
 */


@WebServlet("/removePanel")
public class RemovePanel extends HttpServlet {

    @Autowired
    private UserDAO userDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        try {
            userDAO.deleteUser(login);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect(req.getContextPath() + "/adminPanel");
    }
}
