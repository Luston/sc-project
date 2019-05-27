package com.springcloud.scclient.service.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservable;
import com.netflix.hystrix.HystrixObservableCommand;
import org.springframework.web.client.RestTemplate;

public class HyCommand extends HystrixCommand<String>{
    private String name;
    private RestTemplate restTemplate;

    public HyCommand(String commandGroupKey,String name,RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey(commandGroupKey));
        this.name=name;
        this.restTemplate=restTemplate;
    }

    @Override
    protected String run() throws Exception {
        return restTemplate.getForObject("http://provider-hi/hi?name="+name,String.class);
    }
    @Override
    protected String getFallback(){
        return "error";
    }
}
