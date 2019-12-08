package com.ftf.ftfProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class Message implements Serializable {

    //信息id
    private String messagesId;
    //类型
    private String messagesType;
    //内容
    private String messagesInfo;
    //时间
    private Date messagesTime;
    //收藏数
    private Integer messagesCollectnum;
    //评论数
    private Integer messagesCommentnum;
    //转发数
    private Integer messagesTranspondnum;
    //赞同数
    private Integer messagesAgreenum;
    //阅读数
    private Integer messagesReadnum;
    //标签
    private String messagesLabel;

    private String userId;

    private Users users;

    private Integer messagesState;
    private String stateStr;

    public String getStateStr() {
        if (messagesState==1){
            stateStr="以过审";
        }else if (messagesState==0){
            stateStr="待审";
        }
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getMessagesState() {
        return messagesState;
    }
}
