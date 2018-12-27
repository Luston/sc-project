package com.springcloud.scprovider.controller;

import com.springcloud.scprovider.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DemoContrl {
    @Resource
    private DemoService demoService;
    @RequestMapping("/hi")
    public String say(String name){
        return demoService.say(name);
    }

    @RequestMapping("/sendByDirect")
    public String sendByDirect(String words){
        System.out.println("123");
        demoService.sendMes(words);
        return "OK";
    }

    @RequestMapping("/sendBytopic")
    public String sendByTopic(String words){
        System.out.println("123");
        demoService.sendMesByTopic(words);
        return "OK";
    }
    @RequestMapping("/sendBytopic2")
    public String sendBytopic2(String words){
        System.out.println("123");
        demoService.sendMesByTopic2(words);
        return "OK";
    }
    @RequestMapping("/sendByfanout")
    public String sendByfanout(String words){
        System.out.println("123");
        demoService.sendMesByfanout(words);
        return "OK";
    }
}
