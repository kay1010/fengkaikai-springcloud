package com.example.userservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private static Logger logger= LoggerFactory.getLogger(UserController.class);


    @GetMapping("/user/{userName}")
    private Map<String,Object> getUser(@PathVariable("userName") String userName, HttpServletRequest request){
        logger.info("------------reuqest url:"+request.getRequestURL());
       Map<String,Object> user= new HashMap<>();
       user.put("user",userName);
       return user;

    }


}
