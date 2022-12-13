package com.example.demo.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


/**
 * Author : Evgeniy Nechaev.
 * Created : 06/12/2022.
 * Servlet AdminMenu
 */


@WebServlet("/adminMenu")
public class AdminMenu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/adminmenu.jsp").forward(req, resp);
    }
}
