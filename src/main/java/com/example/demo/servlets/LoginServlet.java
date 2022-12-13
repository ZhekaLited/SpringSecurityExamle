package com.example.demo.servlets;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.LoginDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Author : Evgeniy Nechaev.
 * Created : 06/12/2022.
 * Servlet LoginServlet
 */


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Autowired
    private LoginDAO loginDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User loginBean = new User();
        loginBean.setLogin(login);
        loginBean.setPassword(password);
        if (login.equals("")) {
            response.sendRedirect(request.getContextPath() + "/login?er=login");
        } else {
            if (password.equals("")) {
                response.sendRedirect(request.getContextPath() + "/login?er=password");
            } else {
                    try {
                        if (loginDao.findByUserAuth(loginBean)) {
                            HttpSession session = request.getSession();
                            session.setAttribute("login", login);
                            session.setAttribute("password", password);

                            boolean isAdmin = false;
                            session.setAttribute("role", "User");

                            for (Role role : loginDao.findByRolesAuth(login))
                                if (role.getName().equals("Admin") ||
                                        role.getName().equals("Editor")) {
                                    session.setAttribute("role", "Admin");
                                    isAdmin = true;
                                    break;
                                }

                            response.sendRedirect(request.getContextPath() + (isAdmin ? "/adminMenu" : "/welcome"));
                        } else {
                            response.sendRedirect(request.getContextPath() + "/login");
                        }

                    } catch (ClassNotFoundException | SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }