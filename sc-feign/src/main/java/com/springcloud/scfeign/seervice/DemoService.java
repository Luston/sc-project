package com.springcloud.scfeign.seervice;


import com.springcloud.scfeign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider-hi",fallback = DemoServiceImpl.class)
public interface DemoService {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String say(@RequestParam(value = "name") String name);

    @RequestMapping("/user")
    User getUser(@RequestParam(value = "name")String name);
}
