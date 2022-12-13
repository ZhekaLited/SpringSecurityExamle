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
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;


/**
 * Author : Evgeniy Nechaev.
 * Created : 06/12/2022.
 * Servlet EditPanel
 */


@WebServlet("/editPanel")
public class EditPanel extends HttpServlet {

    @Autowired
    private UserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = userDAO.findByLoginUser(req.getParameter("id"));
        List<Role> roles = userDAO.findByUserRole(req.getParameter("id"));

        req.setAttribute("login", user.getLogin());
        req.setAttribute("password", user.getPassword());
        req.setAttribute("name", user.getName());
        req.setAttribute("birthday", user.getBirthday().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        req.setAttribute("salary", user.getSalary());
        for (Role role : roles) {
            switch (role.getName()) {
                case "Admin" -> req.setAttribute("selectedAdmin", "selected");
                case "User" -> req.setAttribute("selectedUser", "selected");
                case "Author" -> req.setAttribute("selectedAuthor", "selected");
                case "Manager" -> req.setAttribute("selectedManager", "selected");
                case "Editor" -> req.setAttribute("selectedEditor", "selected");
            }
        }
        req.getRequestDispatcher("/WEB-INF/jsp/editPanel.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String salary = req.getParameter("salary");
        String birthday = req.getParameter("birthday");

        if (login.equals("") || password.equals("") || name.equals("") || salary.equals("") || birthday.equals("")) {
            resp.sendRedirect(req.getContextPath() + "/editPanel?id=" + req.getParameter("id") + "&er=t");
        } else {
            if (login.equals("") || !Pattern.matches("[A-Za-zАяа-яЁё0-9]+", login)) {
                resp.sendRedirect(req.getContextPath() + "/editPanel?id=" + req.getParameter("id") + "&er=login");
            } else {
                if (password.equals("") || !Pattern.matches("[A-Za-zАяа-яЁё0-9]+", password)) {
                    resp.sendRedirect(req.getContextPath() + "/editPanel?id=" + req.getParameter("id") + "&er=password");
                } else {
                    if (name.equals("") || !Pattern.matches("[A-Za-zАяа-яЁё]+", name)) {
                        resp.sendRedirect(req.getContextPath() + "/editPanel?id=" + req.getParameter("id") + "&er=name");
                    } else {
                        if (salary.equals("") || !Pattern.matches("[0-9]+", salary)) {
                            resp.sendRedirect(req.getContextPath() + "/editPanel?id=" + req.getParameter("id") + "&er=salary");
                        } else {
                            if (birthday.equals("") || !Pattern.matches("[0-9]{2}.[0-9]{2}.[0-9]{4}", birthday)) {
                                resp.sendRedirect(req.getContextPath() + "/editPanel?id=" + req.getParameter("id") + "&er=birthday");
                            } else {


                                LocalDate birthdayy = LocalDate.parse(req.getParameter("birthday"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));

                                int age = Period.between(birthdayy, LocalDate.now()).getYears();
                                List<Role> roles = new ArrayList<>();
                                if (req.getParameterValues("role") != null) {
                                    for (String element : Arrays.asList(req.getParameterValues("role"))) {
                                        roles.add(new Role((new Random()).nextLong(), element));
                                    }
                                }
                                try {
                                    userDAO.updateUser(new User(0L, login, password, age, Integer.parseInt(salary), name, birthdayy, roles), req.getParameter("id"));
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                resp.sendRedirect(req.getContextPath() + "/adminPanel");

                            }

//        if (correct) {
//            resp.sendRedirect(req.getContextPath() + "/editPanel");
//        } else {
                        }
                    }
                }
            }
        }
    }
}