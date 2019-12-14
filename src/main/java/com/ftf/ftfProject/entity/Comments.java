package com.ftf.ftfProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Comments implements Serializable {

    private String commentsId;
    private String commentsInfo;
    private String commentsTime;
    private String messageId;
    private String userchildId;
    private String userparentId;
    private Users userChild;
    private Users userParent;

    public String getUserchildId() {
        return userchildId;
    }

    public void setUserchildId(String userchildId) {
        this.userchildId = userchildId;
    }

    public String getUserparentId() {
        return userparentId;
    }

    public void setUserparentId(String userparentId) {
        this.userparentId = userparentId;
    }

    public Users getUserChild() {
        return userChild;
    }

    public void setUserChild(Users userChild) {
        this.userChild = userChild;
    }

    public Users getUserParent() {
        return userParent;
    }

    public void setUserParent(Users userParent) {
        this.userParent = userParent;
    }
}
