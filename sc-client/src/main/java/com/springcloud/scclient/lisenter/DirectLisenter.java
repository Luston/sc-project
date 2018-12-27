package com.springcloud.scclient.lisenter;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 监听消息队列
 */
@Component
public class DirectLisenter {

    @RabbitListener(queues = "demoQue")
    public void recieveBydemoQue(String words){
        System.out.println("recieve:来自demoQue======="+words);
    }

    @RabbitListener(queues = "topic.queue1")
    public void recieveBytopic(String words){
        System.out.println("recieve:来自topic.queue1======="+words);
    }

    @RabbitListener(queues = "topic.queue2")
    public void recieveBytopic2(String words){
        System.out.println("recieve:来自topic.queue2======="+words);
    }

    @RabbitListener(queues = "fanout.queue1")
    public void recieveByfanout1(String words){
        System.out.println("recieve:来自fanout.queue1======="+words);
    }
    @RabbitListener(queues = "fanout.queue2")
    public void recieveByfanout2(String words){
        System.out.println("recieve:来自fanout.queue2======="+words);
    }
}
