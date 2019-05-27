package com.springcloud.scclient.service;

import com.springcloud.scclient.pojo.UserInfo;
import rx.Observable;

import java.util.concurrent.ExecutionException;

public interface DemoService {
    String say(String name);

    UserInfo getUser(String name);

    Observable<String> StringConcat(String name);
}
