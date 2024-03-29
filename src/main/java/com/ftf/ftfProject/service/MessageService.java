package com.ftf.ftfProject.service;

import com.ftf.ftfProject.entity.Message;

import java.util.List;

public interface MessageService {

    List<Message> getAllMessage();

    void updateMessageState(String messagesId, Integer state);

    List<Message> getMessageByUserId(String userId);

    int gstUserCount();
}
