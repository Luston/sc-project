package com.springcloud.scfeign.controller;

import com.springcloud.scfeign.pojo.User;
import com.springcloud.scfeign.seervice.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoCtlr {
    @Autowired
    DemoService demoService;
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String say(String name){
        return demoService.say(name);
    }

    @RequestMapping(value = "/user")
    public User getUser(String name){
        return demoService.getUser(name);
    }
}
