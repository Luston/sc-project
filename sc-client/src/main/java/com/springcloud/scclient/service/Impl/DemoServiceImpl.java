package com.springcloud.scclient.service.Impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.springcloud.scclient.pojo.UserInfo;
import com.springcloud.scclient.service.DemoService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class DemoServiceImpl implements DemoService{
    @Resource
    private RestTemplate restTemplate;
    @Override
    @HystrixCommand(fallbackMethod = "error")
    public String say(String name) {
        String one=restTemplate.getForObject("http://provider-hi/hi?name="+name,String.class);
        String two= restTemplate.getForObject("http://provider-hi/hi?name="+name,String.class);
        return one+two;
    }

    @Override

    public UserInfo getUser(String name) {
        return restTemplate.getForObject("http://provider-hi/user?name="+name,UserInfo.class);
    }

    public String error(String name){
        return "hi!"+name+",there is an error!";
    }
    public UserInfo errors(String name){
        return new UserInfo();
    }

    @HystrixCommand
    public  Observable<String> StringConcat(String name){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> observer) {
                try {
                    if(!observer.isUnsubscribed()){
                        String one=restTemplate.getForObject("http://provider-hi/hi?name="+name,String.class);
                        observer.onNext(one);
                        String two=restTemplate.getForObject("http://provider-hi/hi?name="+name,String.class);
                        observer.onNext(two);
                        observer.onCompleted();
                    }
                }catch (Exception e){}
            }
        });
    }
}
