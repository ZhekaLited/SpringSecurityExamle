package com.example.demo.repository;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


/**
 * Author : Evgeniy Nechaev.
 * Created : 06/12/2022.
 * UserDao Interface
 */

@Repository
public interface DAOUser {

    boolean checkExistsPerson(String login);

    User findByLoginUser(String login);

    List<Role> findByUserRole(String login);

    List<User> findAllUser();

    boolean createUser( String login, User user ,  List<Role> roles)  throws SQLException;

    boolean updateUser(User user, String id) throws SQLException;

    boolean deleteUser(String login) throws SQLException;



}
