package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.Message;
import com.ftf.ftfProject.mapper.MessageMapper;
import com.ftf.ftfProject.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> getAllMessage() {
        return messageMapper.getAllMessage();
    }

    @Override
    public void updateMessageState(String messagesId, Integer state) {
        messageMapper.updateMessageState(messagesId,state);
    }

    @Override
    public List<Message> getMessageByUserId(String userId) {
        return messageMapper.getMessageByUserId(userId);
    }

    @Override
    public int gstUserCount() {
        return messageMapper.gstUserCount();
    }
}
