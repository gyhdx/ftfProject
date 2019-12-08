package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Message;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {

    @Select("select * from message")
    List<Message> getAllMessage();

    @Update("update message set messages_state=#{state} where messages_id=#{messagesId}")
    void updateMessageState(String messagesId, Integer state);
}


