package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Role;
import com.ftf.ftfProject.entity.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    @Update("update users set user_count=#{i} where user_id=#{id}")
    void updateUserCount(int i, String id);

    @Update("update users set user_status=#{i} where user_id=#{id}")
    void updateUserState(int i, String id);

    @Delete("delete from users where user_id=#{id}")
    void deleteUser(String id);

    @Select("select count(user_id) from users")
    int gstUserCount();

    @Select("select * from role where role_id = (select role_id from role_user where users_id = #{id})")
    Role getRoleById(String id);

    @Update("update users set user_lasttime=#{date} where user_id=#{id}")
    void updateLastTime(Date date, String id);
}