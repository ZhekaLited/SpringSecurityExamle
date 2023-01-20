package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Role;
import jakarta.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String login = username;
        UserDetails userDetails = userMapper.getAllLogin(username);
        List<Role> role = userMapper.getAllRole(login);

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.get(0).getName());
        authorities.add(authority);
        org.springframework.security.core.userdetails.User.UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username)
                .password(userDetails.getPassword());
        return builder.authorities(authorities).build();
    }
}

//        ArrayList<Role> role = new ArrayList<Role>();
//        role.add(new Role(Long.valueOf(0),"ADMIN"));
//
//
//        User userByUsername = new User();
//            userByUsername.setId(Long.valueOf(1));
//            userByUsername.setRole(role);
//            userByUsername.setActive(true);
//            userByUsername.setLogin(username);
//            userByUsername.setPassword("$2a$10$yJ4aV3iwusIwsYKqTJlDreZGNkyLGiqicZ6VCaq3s4es0Thoz.cMC");
//
//        if (userByUsername == null) {
//            throw new UsernameNotFoundException("User not authorized.");
//        }

//                .roles("ADMIN");
//        builder.password("$2a$10$yJ4aV3iwusIwsYKqTJlDreZGNkyLGiqicZ6VCaq3s4es0Thoz.cMC").roles("ADMIN").build();

