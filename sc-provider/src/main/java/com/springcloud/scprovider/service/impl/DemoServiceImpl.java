package com.springcloud.scprovider.service.impl;

import com.springcloud.scprovider.pojo.UserInfo;
import com.springcloud.scprovider.service.DemoService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService{

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${server.port}")
    String port;
    @Override
    public String say(String name) {
        return "hi! "+name+",i am from "+port;
    }

    @Override
    public void sendMes(String words) {
        this.rabbitTemplate.convertAndSend("demoQue",words);
    }

    @Override
    public void sendMesByTopic(String words) {
        this.rabbitTemplate.convertAndSend("topicExchange","topic1.queue1",words);
    }
    @Override
    public void sendMesByTopic2(String words) {
        this.rabbitTemplate.convertAndSend("topicExchange","topic.queue2",words);
    }

    @Override
    public void sendMesByfanout(String words) {
        this.rabbitTemplate.convertAndSend("fanoutExchange","",words);
    }
    @Override
    public UserInfo sendUser(String name) {
        UserInfo userInfo=UserInfo.INSTANCE;
        userInfo.setUserName(name);
        userInfo.setAge(18);
        userInfo.setAddress("上海");
        return userInfo;
    }
}
