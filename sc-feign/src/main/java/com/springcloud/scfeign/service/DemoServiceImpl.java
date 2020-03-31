package com.springcloud.scfeign.service;

import com.springcloud.scfeign.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

@Component
public class DemoServiceImpl implements DemoService{
    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
    @Override
    public String say(String name) {
        logger.info("");
        return "hi!"+name+",there is an error!";
    }

    @Override
    public User getUser(String name) {
        return new User();
    }
}
