package com.example.demo.service;


import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


/**
 * Author : Evgeniy Nechaev.
 * Created : 06/12/2022.
 * Service UserService Interface
 */


@Service
public interface UserService {
    boolean checkExistsPerson(String login);

    User findByLoginUser(String login);

    List<Role> findByUserRole(String login);

    List<User> findAllUser();

    boolean createUser(User user,List<Role> roles) throws SQLException;

    boolean updateUser(User user, List<Role> roles, String id) throws SQLException;

    boolean deleteUser(String login) throws SQLException;

    boolean findByUserAuth(String username) throws ClassNotFoundException;

    List<Role> findByRolesAuth(String login) throws SQLException;


}
