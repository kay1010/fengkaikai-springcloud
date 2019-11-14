package com.example.customerservice.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {
    Logger logger= LoggerFactory.getLogger(CustomerController.class);


    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/user/{userName}")
    private String getUser(@PathVariable("userName") String userName){
        logger.info("-------CustomerController request USER-SERVICE for getUser-----");
        return restTemplate.getForObject("http://USER-SERVICE/user/"+userName,String.class);
    }
}
