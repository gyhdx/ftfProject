package com.ftf.ftfProject.service;

import com.ftf.ftfProject.entity.Role;
import com.ftf.ftfProject.entity.Users;

import java.util.Date;
import java.util.List;

public interface UserService {

    List<Users> selectAll();

    Users findById(String userId);
    Users findByEmail(String email);

    void addUser(Users users);

    void updateUserCount(int i, String userId);

    void updateUserState(int i, String userID);

    void deleteUser(String userID);

    int gstUserCount();

    Role getRoleById(String userId);

    void updateLastTime(Date date, String id);
}
