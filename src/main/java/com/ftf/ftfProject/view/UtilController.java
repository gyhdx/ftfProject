package com.ftf.ftfProject.view;

import com.ftf.ftfProject.entity.Logger;
import com.ftf.ftfProject.entity.Users;
import com.ftf.ftfProject.service.LoggerService;
import com.ftf.ftfProject.service.MessageService;
import com.ftf.ftfProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/util")
public class UtilController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private LoggerService loggerService;

    @RequestMapping("/getData")
    @ResponseBody
    public Map<String,Integer> getData(){
        Map<String,Integer> map = new HashMap<>();
        int userCount = userService.gstUserCount();
        int mesCount = messageService.gstUserCount();
        int logCount = loggerService.gstLogCount();
        map.put("userCount",userCount);
        map.put("mesCount",mesCount);
        map.put("logCount",logCount);

        return map;
    }

    @RequestMapping("/gatAllLog")
    @ResponseBody
    public List<Logger> gatAllLog(HttpServletRequest request){
        List<Logger> loggerList =  loggerService.gatAllLog();
        Users user = (Users) request.getSession().getAttribute("user");
        loggerService.addLogger(user.getUserId(),"查看日志记录");
        return loggerList;
    }
}
