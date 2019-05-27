package com.springcloud.scprovider.service;

import com.springcloud.scprovider.pojo.UserInfo;

public interface DemoService {
    String say(String name);

    void sendMes(String words);

    void sendMesByTopic(String words);
    void sendMesByTopic2(String words);

    void sendMesByfanout(String words);

    UserInfo sendUser(String name);
}
