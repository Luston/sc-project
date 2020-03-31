package com.springcloud.scprovider.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class RabbitMqConfig {

    /**
     *direct Exchange形式
     */
    @Bean
    public Queue queue(){
        return new Queue("demoQue",true);
    }
    /**
     * topic Exchange形式
     */
    @Bean
    public Queue queue1(){
        return new Queue("topic.queue1");
    }
    @Bean
    public Queue queue2(){
        return new Queue("topic.queue2");
    }
    @Bean
    /**
     * 参数1 name ：交互器名
     * 参数2 durable ：是否持久化
     * 参数3 autoDelete ：当所有消费客户端连接断开后，是否自动删除队列
     */
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange",true,false);
    }
    /**
     * fanout Exchange形式
     */
    @Bean
    public Queue queue3(){
        return new Queue("fanout.queue1");
    }
    @Bean
    public Queue queue4(){
        return new Queue("fanout.queue2");
    }
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }
    /**
     *topic Exchange 绑定
     */
    @Bean
    public Binding bindingExchangeMessage1(Queue queue1,TopicExchange topicExchange){
        return BindingBuilder.bind(queue1).to(topicExchange).with("topic.queue1");
    }

    //#为通配符
    @Bean
    public Binding bindingExchangeMessage2(Queue queue2,TopicExchange topicExchange){
        return BindingBuilder.bind(queue2).to(topicExchange).with("topic.#");
    }

    /**
     *fanout Exchange 绑定
     */
    @Bean
    public Binding bindingExchangeMessage3(Queue queue3,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue3).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeMessage4(Queue queue4,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue4).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeMessage(Queue queue,DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("direct");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                if(b){
                    System.out.println("发送到交换机成功。。");
                }else{
                    System.out.println("发送到交换机失败。。");
                }
            }
        });
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int i, String s, String s1, String s2) {
                String correlationId = message.getMessageProperties().getCorrelationIdString();
                System.out.println("correlationId......"+correlationId);
            }
        });
        return rabbitTemplate;
    }
}
