package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("select * from users")
    List<Users> selectAll();

    @Select("select * from users where user_id=#{id}")
    Users sclectById(String id);

    @Select("select * from users where user_email=#{email}")
    Users selectByEmail(String email);

    @Insert("insert into users(user_email,user_password,user_nikename,user_time,user_sex,user_status,user_Img,user_birthday)" +
            " values(#{userEmail},#{userPassword},#{userNikename},#{userTime},#{userSex},#{userStatus},#{userImg},#{userBirthday})")
    void insertUser(Users users);
}