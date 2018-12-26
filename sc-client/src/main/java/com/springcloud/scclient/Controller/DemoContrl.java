package com.springcloud.scclient.Controller;

import com.springcloud.scclient.service.DemoService;
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

}
