package com.springcloud.scclient.service.Impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.scclient.service.DemoService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class DemoServiceImpl implements DemoService{
    @Resource
    private RestTemplate restTemplate;
    @Override
    @HystrixCommand(fallbackMethod = "error")
    public String say(String name) {
        return restTemplate.getForObject("http://provider-hi/hi?name="+name,String.class);
    }

    public String error(String name){
        return "hi!"+name+",there is an error!";
    }
}
