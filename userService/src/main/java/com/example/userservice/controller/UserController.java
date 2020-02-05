package com.example.userservice.controller;

import com.example.userservice.service.MqSendService;
import com.example.userservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "MQ API")
@CrossOrigin//实现跨域访问
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

    @ApiOperation("send msg for Queue")
    @RequestMapping(value="/user/sendp2p/{userName}",method = RequestMethod.GET)
    public String sendMsg_p2p(@PathVariable("userName") String userName){
        userService.addUser(userName);
        mqSendService.SendMsgP2p(queue,userName);
        return "success";
    }

    @ApiOperation("send msg for Topic")
    @RequestMapping(value="/user/sendtopic/{userName}",method = RequestMethod.GET)
    public String sendMsg_topic(@PathVariable("userName") String userName){
        userService.addUser(userName);
        mqSendService.SendMsgTopic(topic,userName);
        return "success";
    }


}
