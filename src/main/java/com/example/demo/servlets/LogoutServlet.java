package com.example.demo.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Logout.
 * Delete session.
 */

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        resp.setContentType("text/html");

        req.getRequestDispatcher(req.getContextPath() + "/login").include(req, resp);

        HttpSession session=req.getSession();
        session.invalidate();


    }

}
