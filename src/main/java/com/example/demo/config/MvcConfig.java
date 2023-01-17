package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/welcome").setViewName("src/main/webapp/WEB-INF/jsp/welcome.jsp");
        registry.addViewController("/adminmenu").setViewName("src/main/webapp/WEB-INF/jsp/adminmenu.jsp");
        registry.addViewController("/login").setViewName("login");
    }
}
