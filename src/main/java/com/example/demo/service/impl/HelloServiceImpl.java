package com.example.demo.service.impl;

import com.example.demo.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * Created by damei on 19/2/22.
 */
@Component
public class HelloServiceImpl implements HelloService{
    @Override
    public String sayHello() {
        return "Hello World!";
    }

}
