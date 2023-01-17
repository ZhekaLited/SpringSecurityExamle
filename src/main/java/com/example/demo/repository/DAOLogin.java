package com.example.demo.repository;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Author : Evgeniy Nechaev.
 * Created : 06/12/2022.
 * LoginDao Interface
 */

@Repository
public interface DAOLogin {

    boolean findByUserAuth(String username) throws ClassNotFoundException;

    List<Role> findByRolesAuth(String login) throws SQLException;
}
