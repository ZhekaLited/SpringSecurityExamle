package com.example.demo.repository;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Author : Evgeniy Nechaev.
 * Created : 06/12/2022.
 * LoginDao
 */

@Repository
public class LoginDAO implements DAOLogin {

    @Autowired
    private UserMapper userMapper;

    public boolean findByUserAuth(User loginBean) throws ClassNotFoundException {
        return userMapper.getAllLogin(loginBean) != null;

    }

    public List<Role> findByRolesAuth(String login) throws SQLException {
        List<Role> roles = userMapper.getAllRole(login);
        return roles;
    }
}
