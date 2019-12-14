package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Logger;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LoggerMapper {

    @Select("select count(logger_id) from logger")
    int gstLogCount();

    @Insert("insert into logger (logger_time,user_id,logger_do) value (#{date},#{userId},#{s})")
    void addLogger(String userId, String s, Date date);

    @Select("select * from logger")
    List<Logger> gatAllLog();
}
