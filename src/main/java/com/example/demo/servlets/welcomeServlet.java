package com.example.demo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Welcome.
 * Show welcome page.
 */

@WebServlet("/welcome")
public class welcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("hide", "hidden");
        req.setAttribute("hideAdmin", "hidden");
        req.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(req, resp);
    }
}
