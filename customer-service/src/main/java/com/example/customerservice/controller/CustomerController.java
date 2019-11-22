package com.example.customerservice.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@Api(tags = "Customer API" ,description = "customer相关Rest API")
@RestController
public class CustomerController {
    Logger logger= LoggerFactory.getLogger(CustomerController.class);


    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation("获取用户姓名")
    @GetMapping("/user/{userName}")
    private String getUser(@PathVariable("userName") String userName){
        logger.info("-------CustomerController request USER-SERVICE for getUser-----");
        return restTemplate.getForObject("http://USER-SERVICE/user/"+userName,String.class);
    }
}
