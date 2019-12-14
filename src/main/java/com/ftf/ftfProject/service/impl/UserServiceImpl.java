package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.Message;
import com.ftf.ftfProject.entity.Role;
import com.ftf.ftfProject.entity.Users;
import com.ftf.ftfProject.mapper.UserMapper;
import com.ftf.ftfProject.service.MessageService;
import com.ftf.ftfProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MessageService messageService;

    @Override
    public List<Users> selectAll() {
        List<Users> usersList = userMapper.selectAll();
        for (Users user : usersList) {
            List<Message> messages = messageService.getMessageByUserId(user.getUserId());
            user.setMessageList(messages);
            user.setMessages(messages.size());
            user.setRole(getRoleById(user.getUserId()));
        }

        return usersList;
    }

    @Override
    public Users findById(String userId) {
        Users users = userMapper.sclectById(userId);
        users.setRole(getRoleById(userId));
        return users;
    }

    @Override
    public Users findByEmail(String email) {

        Users users = userMapper.selectByEmail(email);
        users.setRole(getRoleById(users.getUserId()));
        return users;
    }

    @Override
    public void addUser(Users users) {
        userMapper.insertUser(users);
    }

    @Override
    public void updateUserCount(int i, String userId) {
        userMapper.updateUserCount(i,userId);
    }

    @Override
    public void updateUserState(int i, String userID) {
        userMapper.updateUserState(i,userID);
    }

    @Override
    public void deleteUser(String userID) {
        userMapper.deleteUser(userID);
    }

    @Override
    public int gstUserCount() {
        return userMapper.gstUserCount();
    }

    @Override
    public Role getRoleById(String userId) {
        return userMapper.getRoleById(userId);
    }

    @Override
    public void updateLastTime(Date date, String id) {
        userMapper.updateLastTime(date,id);
    }
}
