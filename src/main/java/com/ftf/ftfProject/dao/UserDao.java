package com.ftf.ftfProject.dao;

import com.ftf.ftfProject.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<Users> selectAll();
}
