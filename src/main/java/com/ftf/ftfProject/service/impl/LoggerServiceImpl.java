package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.Logger;
import com.ftf.ftfProject.entity.Users;
import com.ftf.ftfProject.mapper.LoggerMapper;
import com.ftf.ftfProject.service.LoggerService;
import com.ftf.ftfProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoggerServiceImpl implements LoggerService {

    @Autowired
    private LoggerMapper loggerMapper;

    @Autowired
    private UserService userService;

    @Override
    public int gstLogCount() {
        return loggerMapper.gstLogCount();
    }

    @Override
    public void addLogger(String userId, String s) {
        Date date = new Date();
        loggerMapper.addLogger(userId,s,date);
    }

    @Override
    public List<Logger> gatAllLog() {
        List<Logger> loggerList = loggerMapper.gatAllLog();
        for (Logger logger : loggerList) {
            Users byId = userService.findById(logger.getUserId());
            logger.setUsers(byId);
        }
        return loggerList;
    }
}
