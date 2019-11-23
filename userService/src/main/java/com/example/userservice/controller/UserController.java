package com.example.userservice.controller;

import com.example.userservice.service.MqSendService;
import com.example.userservice.service.UserService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jms.Queue;
import javax.jms.Topic;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private static Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private MqSendService mqSendService;


    @Autowired
    private Queue queue;//config中配置初始化了名为p2p的队列


    @Autowired
    private Topic topic;//config中配置初始化了名为topic的队列

    @GetMapping("/user/{userName}")
    private Map<String,Object> getUser(@PathVariable("userName") String userName, HttpServletRequest request){
        logger.info("------------reuqest url:"+request.getRequestURL());
       Map<String,Object> user= new HashMap<>();
       user.put("user",userName);
       return user;

    }


    @RequestMapping("/user/sendp2p/{userName}")
    public String sendMsg_p2p(String userName){
        userService.addUser(userName);
        mqSendService.SendMsgP2p(queue,userName);
        return "success";
    }

    @RequestMapping("/user/sendtopic/{userName}")
    public String sendMsg_topic(String userName){
        userService.addUser(userName);
        mqSendService.SendMsgTopic(topic,userName);
        return "success";
    }


}
