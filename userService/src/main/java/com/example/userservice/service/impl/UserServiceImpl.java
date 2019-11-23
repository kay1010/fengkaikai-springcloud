package com.example.userservice.service.impl;

import com.example.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public void addUser(String userName) {
        logger.info("-------UserService addUser by userName = {} success!",userName);

    }
}
