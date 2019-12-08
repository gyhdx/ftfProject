package com.ftf.ftfProject.service;

import com.ftf.ftfProject.entity.Users;

import java.util.List;

public interface UserService {

    List<Users> selectAll();

    Users findById();
    Users findByEmail(String email);

    void addUser(Users users);
}
