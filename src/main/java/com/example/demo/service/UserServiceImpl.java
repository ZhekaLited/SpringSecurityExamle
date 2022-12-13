package com.example.demo.service;


import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.LoginDAO;
import com.example.demo.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


/**
 * Author : Evgeniy Nechaev.
 * Created : 06/12/2022.
 * Service UserServiceImpl
 */


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final LoginDAO loginDao;

//
//    CRUD
//    create read update delete findAll findByLogin findByLoginAndEmail existsByLogin count
//
//    createUser readUser update delete findAllUsers findUserByLogin findByLoginAndEmail existsByLogin count
//    @Override
//    public boolean Validation(String login, String password, String salary, String name, String birthday) {
//        return (userDAO.Validation(login, password, salary, name, birthday));
//    }

    @Override
    public boolean checkExistsPerson(String login) {
        return (userDAO.checkExistsPerson(login));
    }

    @Override
    public User findByLoginUser(String login) {
        return (userDAO.findByLoginUser(login));
    }

    @Override
    public List<Role> findByUserRole(String login) {
        return (userDAO.findByUserRole(login));
    }

    @Override
    public List<User> findAllUser() {
        return (userDAO.findAllUser());
    }

    @Override
    public boolean createUser(String login , User user ,List<Role> roles) throws SQLException {
        return (userDAO.createUser(login ,user , roles));
    }

    @Override
    public boolean updateUser(User user, String id) throws SQLException {
        return (userDAO.updateUser(user, id));
    }

    @Override
    public boolean deleteUser(String login) throws SQLException {
        return (userDAO.deleteUser(login));
    }

    @Override
    public boolean findByUserAuth(User loginBean) throws ClassNotFoundException {
        return (loginDao.findByUserAuth(loginBean));
    }

    @Override
    public List<Role> findByRolesAuth(String login) throws SQLException {
        return (loginDao.findByRolesAuth(login));
    }
}
