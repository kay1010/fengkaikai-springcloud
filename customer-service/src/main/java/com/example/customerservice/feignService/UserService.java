package com.example.customerservice.feignService;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "USER-SERVICE")
public interface UserService {
    @GetMapping("/user/{userName}")
    String getUser(@PathVariable("userName ") String name);
}
