package com.springcloud.scprovider.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    /**
     *direct Exchange形式
     */
    @Bean
    public Queue queue(){
        return new Queue("demoQue");
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
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
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
     *fanout Excahnge 绑定
     */
    @Bean
    public Binding bindingExchangeMessage3(Queue queue3,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue3).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeMessage4(Queue queue4,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue4).to(fanoutExchange);
    }

}
