package com.springcloud.scfeign.service;

import com.springcloud.scfeign.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class DemoServiceImpl implements DemoService{

    @Override
    public String say(String name) {
        return "hi!"+name+",there is an error!";
    }

    @Override
    public User getUser(String name) {
        return new User();
    }
}
