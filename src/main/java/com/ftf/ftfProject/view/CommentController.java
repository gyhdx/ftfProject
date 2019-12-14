package com.ftf.ftfProject.view;

import com.ftf.ftfProject.entity.Comments;
import com.ftf.ftfProject.service.CommentsService;
import com.ftf.ftfProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private UserService userService;

    @RequestMapping("/getById")
    @ResponseBody
    public List<Comments> getComByMesId(@RequestParam("id")String messagesId){
        List<Comments> commentsList = commentsService.getComByMesId(messagesId);
        for (Comments comments : commentsList) {
            comments.setUserChild(userService.findById(comments.getUserchildId()));
            comments.setUserParent(userService.findById(comments.getUserparentId()));
        }
//        System.out.println(commentsList);
        return commentsList;
    }
}
