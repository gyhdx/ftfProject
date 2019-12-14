package com.ftf.ftfProject.view;

import com.alibaba.fastjson.JSONObject;
import com.ftf.ftfProject.entity.Message;
import com.ftf.ftfProject.entity.Users;
import com.ftf.ftfProject.service.LoggerService;
import com.ftf.ftfProject.service.MessageService;
import com.ftf.ftfProject.service.UserService;
import com.ftf.ftfProject.utils.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    @Autowired
    private LoggerService loggerService;

    public static String YZM=null;

    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<Users> getAllUser(HttpServletRequest request){
        List<Users> users = userService.selectAll();
        Users user = (Users) request.getSession().getAttribute("user");
        loggerService.addLogger(user.getUserId(),"查看用户管理");
        return users;
    }

    @RequestMapping("/getUserInfo")
    public Users getUserInfo(HttpServletRequest request){
        Users user = (Users) request.getSession().getAttribute("user");
//        System.out.println();
        return user;
    }

    @RequestMapping("/deleteUser")
    public void deleteUser(@RequestParam("id")String userID){
        userService.deleteUser(userID);
    }

    @RequestMapping("/updateUserState")
    public Users updateUserState(@RequestParam("id")String userID){
        Users users = userService.findById(userID);
        if (users.getUserStatus()==1){
            userService.updateUserState(0,userID);
        }else {
            userService.updateUserState(1,userID);
        }
        return null;
    }

    @RequestMapping("/findById")
    public boolean findById(@RequestBody Users user,HttpServletRequest request){
        Users users = userService.findByEmail(user.getUserEmail());
        if (users==null){
            return false;
        }
        if (user.getUserEmail().equals(users.getUserEmail())&&user.getUserPassword().equals(users.getUserPassword())&&users.getUserStatus()==1){
            request.getSession().setAttribute("user",users);
//            System.out.println(users);
            userService.updateUserCount(users.getUserCount()+1,users.getUserId());
            loggerService.addLogger(users.getUserId(),"登录系统");
            Date date = new Date();
            userService.updateLastTime(date,users.getUserId());
            return true;
        }
        return false;
    }

    @RequestMapping("/register")
    public boolean register(@RequestBody JSONObject jsonParam){

        String yzm = (String) jsonParam.get("yzm");
        String userEmail = (String) jsonParam.get("userEmail");
        String userPassword = (String) jsonParam.get("userPassword");
        if (YZM.equals(yzm)){
            Users users = new Users();
            users.setUserEmail(userEmail);
            users.setUserPassword(userPassword);
            users.setUserTime(new Date());
            users.setUserStatus(1);
            userService.addUser(users);

            return true;
        }else {
            return false;
        }

    }

    @RequestMapping("/checkName")
    public boolean checkName(@RequestParam(name = "userEmail",required = true) String userEmail){
        Users users = userService.findByEmail(userEmail);
        if (users==null){
            return true;
        }else {
            return false;
        }

    }

    @RequestMapping("/sendYZM")
    public boolean sendYZM(@RequestParam(name = "userEmail",required = true) String userEmail){
        YZM = EmailUtil.YZMUtil();
        try {
            EmailUtil.sendEmail(userEmail,YZM);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
