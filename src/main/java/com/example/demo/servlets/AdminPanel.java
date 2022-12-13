package com.example.demo.servlets;


import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

/**
 * Author : Evgeniy Nechaev.
 * Created : 06/12/2022.
 * Servlet AdminPanel
 */

@WebServlet("/adminPanel")
public class AdminPanel extends HttpServlet {

    @Autowired
    private UserDAO userDAO;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("hide", "hidden");
        List<User> listUser = userDAO.findAllUser();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("WEB-INF/jsp/adminPanel.jsp").forward(request, response);
    }
}
