package com.springcloud.scclient.Controller;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.springcloud.scclient.pojo.UserInfo;
import com.springcloud.scclient.service.DemoService;
import com.springcloud.scclient.service.command.HyCommand;
import com.springcloud.scclient.service.command.HyObserver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Observer;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

@RestController
public class DemoContrl {

    @Resource
    private DemoService demoService;
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String say(String name){
        return demoService.say(name);

    }
    @RequestMapping("/his")
    public String says(String name){
        HyCommand hyCommand=new HyCommand("lean","lean",restTemplate);

        try {
            return hyCommand.queue().get();
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }

    }

    @RequestMapping("/user")
    public UserInfo getUser(String name){
        return demoService.getUser(name);
    }
    @RequestMapping("/more")
    public String stringConcat(String name){

        HyObserver hyObserver=new HyObserver();
        Observable<String> observable=demoService.StringConcat(name);
        observable.subscribe(hyObserver);
        return hyObserver.sout();

    }

}
