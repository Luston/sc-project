package com.springcloud.scprovider.service.impl;

import com.springcloud.scprovider.service.DemoService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService{

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${server.port}")
    String port;
    @Override
    public String say(String name) {
        return "hi! "+name+",i am from "+port;
    }

    @Override
    public void sendMes(String words) {
        this.amqpTemplate.convertAndSend("demoQue",words);
    }
}
