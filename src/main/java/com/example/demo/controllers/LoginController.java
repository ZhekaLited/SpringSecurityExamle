package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class LoginController {

    @GetMapping("/login")
    public String getlogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }

    @GetMapping("/adminmenu")
    public String getAdmin() {
        return "adminmenu";
    }

    @GetMapping("/welcome")
    public String getUser() {
        return "welcome";
    }
}



////    @GetMapping("/login")
////    public String getAuthorization(HttpServletRequest req, Model model) {
////
////        model.addAttribute("user", new User());
////
////        if (req.getSession().getAttribute("login") == null) {
////            return "login";
////        } else {
////            if (req.getSession().getAttribute("role").equals("Admin")) {
////                return "redirect:/adminMenu";
////            } else {
////                if (req.getSession().getAttribute("role").equals("User")) {
////                    return "redirect:/welcome";
////                } else {
////                    return "login";
////                }
////            }
////        }
////    }
////
////    @PostMapping("/login")
////    public String postAuthorization(HttpServletRequest req, @ModelAttribute("user") @Valid User user, BindingResult result) {
////
////        String page = null;
////        String login = req.getParameter("login");
////        String password = req.getParameter("password");
////
////        User loginBean = new User();
////        loginBean.setLogin(login);
////        loginBean.setPassword(password);
////        try {
////            if (userService.findByUserAuth(loginBean)) {
////                HttpSession session = req.getSession();
////                session.setAttribute("login", login);
////                session.setAttribute("password", password);
////
////                session.setAttribute("role", "User");
////
////                for (Role role : userService.findByRolesAuth(login))
////                    if (role.getName().equals("Admin") ||
////                            role.getName().equals("Editor")) {
////                        session.setAttribute("role", "Admin");
////                        page = "redirect:/adminMenu";
////                        break;
////                    } else {
////                        page = "redirect:/welcome";
////                    }
////            }
////        } catch (ClassNotFoundException | SQLException e) {
////            throw new RuntimeException(e);
////        }
////        return page;
////    }