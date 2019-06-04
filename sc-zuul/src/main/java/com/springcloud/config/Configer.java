package com.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configer {
    @Bean
    public DefineFilter getDefineFilter(){
        return new DefineFilter();
    }
}
