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
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * Author : Evgeniy Nechaev.
 * Created : 06/12/2022.
 * Servlet AddPanel
 */


@WebServlet("/addPanel")
public class AddPanel extends HttpServlet {

    @Autowired
    private UserDAO userDAO;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String salary = request.getParameter("salary");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");

        if (login.equals("") || password.equals("") || salary.equals("") || name.equals("") || birthday.equals("")) {
            response.sendRedirect(request.getContextPath() + "/addPanel?er=t");
        } else {
            if (login.equals("") || !Pattern.matches("[a-zA-Za-яА-Я0-9]+", login)) {
                response.sendRedirect(request.getContextPath() + "/addPanel?er=login");
            } else {
                if (password.equals("") || !Pattern.matches("[A-Za-zАяа-яЁё0-9]+", password)) {
                    response.sendRedirect(request.getContextPath() + "/addPanel?er=password");
                } else {
                    if (salary.equals("") || !Pattern.matches("[0-9]+", salary)) {
                        response.sendRedirect(request.getContextPath() + "/addPanel?er=salary");
                    } else {
                        if (name.equals("") || !Pattern.matches("[A-Za-zАяа-яЁё]+", name)) {
                            response.sendRedirect(request.getContextPath() + "/addPanel?er=name");
                        } else {
                            if (birthday.equals("") || !Pattern.matches("[0-9]{2}.[0-9]{2}.[0-9]{4}", birthday)) {
                                response.sendRedirect(request.getContextPath() + "/addPanel?er=birthday");
                            }

                            List<Role> roles = new ArrayList<>();
                            if (request.getParameterValues("role") != null) {
                                for (String element : Arrays.asList(request.getParameterValues("role"))) {
                                    roles.add(new Role((new Random()).nextLong(), element));
                                }
                            }

                            LocalDate birthdayy = LocalDate.parse(request.getParameter("birthday"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                            int age = Period.between(birthdayy, LocalDate.now()).getYears();
                            User newUser = new User(0L, login, password, age, Integer.parseInt(salary), name, birthdayy, roles);
                            try {

                                userDAO.createUser(login, newUser, roles);
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            response.sendRedirect(request.getContextPath() + "/adminPanel");
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/jsp/addPanel.jsp").forward(request, response);
    }
}