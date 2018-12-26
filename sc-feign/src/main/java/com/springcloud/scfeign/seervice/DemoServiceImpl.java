package com.springcloud.scfeign.seervice;

import org.springframework.stereotype.Component;

@Component
public class DemoServiceImpl implements DemoService{

    @Override
    public String say(String name) {
        return "hi!"+name+",there is an error!";
    }
}
