package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.Users;
import com.ftf.ftfProject.mapper.UserMapper;
import com.ftf.ftfProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Users> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public Users findById(String userId) {
        return userMapper.sclectById(userId);
    }

    @Override
    public Users findByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

    @Override
    public void addUser(Users users) {
        userMapper.insertUser(users);
    }

    @Override
    public void updateUserCount(int i, String userId) {
        userMapper.updateUserCount(i,userId);
    }
}
