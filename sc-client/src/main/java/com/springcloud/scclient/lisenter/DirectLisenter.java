/*
package com.springcloud.scclient.lisenter;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

*/
/**
 * 监听消息队列
 *//*

@Component
public class DirectLisenter {

    @RabbitListener(queues = "demoQue")
    public void recieveBydemoQue(Message message, Channel channel){
        System.out.println("recieve:来自demoQue======="+new String(message.getBody()));
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
*/
