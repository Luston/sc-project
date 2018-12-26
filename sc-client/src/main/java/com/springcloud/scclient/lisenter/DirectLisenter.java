package com.springcloud.scclient.lisenter;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 监听direct模式的消息队列
 */
@Component
@RabbitListener(queues = "demoQue")
public class DirectLisenter {

    @RabbitHandler
    public void recieve(String words){
        System.out.println("recieve:======="+words);
    }
}
