package com.springcloud.scprovider.service;

public interface DemoService {
    String say(String name);

    void sendMes(String words);

    void sendMesByTopic(String words);
    void sendMesByTopic2(String words);

    void sendMesByfanout(String words);
}
