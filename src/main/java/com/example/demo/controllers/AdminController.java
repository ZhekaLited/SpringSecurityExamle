package com.example.demo.controllers;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class AdminController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/adminPanel")
    public String adminPanel(HttpServletRequest request) {
        request.setAttribute("hide", "hidden");
        List<User> listUser = userService.findAllUser();
        request.setAttribute("listUser", listUser);
        return "adminPanel";
    }

    @GetMapping("/addPanel")
    public String getCreate(Model model) {
        model.addAttribute("user", new User());
        return "addPanel";
    }

    @PostMapping("/addPanel")
    public String postCreate(HttpServletRequest req, @Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "addPanel";
        } else {
            List<Role> roles = new ArrayList<>();
            if (req.getParameterValues("roles") != null) {
                for (String element : Arrays.asList(req.getParameterValues("roles"))) {
                    roles.add(new Role((new Random()).nextLong(), element));
                }
            }
            user.setAge(Period.between(user.getBirthday(), LocalDate.now()).getYears());
            try {
                userService.createUser(user, roles);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return "redirect:/adminPanel";

        }
    }


    @GetMapping("/editPanel")
    public String getUpdate(HttpServletRequest req, Model model) {
        User user = userService.findByLoginUser(req.getParameter("userLogin"));
        List<Role> roles = userService.findByUserRole(req.getParameter("userLogin"));
        model.addAttribute("user", new User());

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
        return "editPanel";
    }

    @PostMapping("/editPanel")
    public String postUpdate(HttpServletRequest req, @Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("login", req.getParameter("userLogin"));
            return "editPanel";
        } else {
            List<Role> roles = new ArrayList<>();
            if (req.getParameterValues("roles") != null) {
                for (String element : Arrays.asList(req.getParameterValues("roles"))) {
                    roles.add(new Role((new Random()).nextLong(), element));
                }
            }
            user.setRole(roles);
            user.setAge(Period.between(user.getBirthday(), LocalDate.now()).getYears());
            try {
                userService.updateUser(user, roles ,  req.getParameter("userLogin"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
            return "redirect:/adminPanel";
    }

    @GetMapping("/removePanel")
    public String delete(@RequestParam("login") String login) {
        try {
            userService.deleteUser(login);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "redirect:adminPanel";
    }
}
