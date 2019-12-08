package com.ftf.ftfProject.view;

import com.ftf.ftfProject.entity.Message;
import com.ftf.ftfProject.service.MessageService;
import com.ftf.ftfProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    public MessageService messageService;

    @Autowired
    public UserService userService;

    @RequestMapping("/getAllMessage")
    @ResponseBody
    public List<Message> getAllMessage(@RequestParam("value") String val){
        int falg=0;
        List<Message> allMessage = messageService.getAllMessage();
        List<Message> messages = new ArrayList<>();
        if (val.equals("1")){
            falg=1;
        }else if (val.equals("0")){
            falg=0;
        }
        for (Message message : allMessage) {

            if (message.getMessagesState()==falg){
                messages.add(message);
            }
        }
        for (Message message : messages) {
            message.setUsers(userService.findById(message.getUserId()));
        }

        return messages;
    }

    @RequestMapping("/updateMessageState")
    @ResponseBody
    public List<Message> updateMessageState(@RequestParam("id")String messagesId,@RequestParam("state")Integer state){
        messageService.updateMessageState(messagesId,state);
        List<Message> messageList = getAllMessage("0");
        return messageList;
    }
}
