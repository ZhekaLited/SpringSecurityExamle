package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * Author : Evgeniy Nechaev.
 * Created : 06/12/2022.
 * Model User
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;

    private String login;

    private String password;

    private int age;

    private int salary;

    private String name;

    private LocalDate birthday = null;

    private List<Role> role;

}
