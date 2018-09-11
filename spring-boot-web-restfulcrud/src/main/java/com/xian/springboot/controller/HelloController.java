package com.xian.springboot.controller;

import com.xian.springboot.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

//    @RequestMapping({"/","index.html"})
//    public String index() {
//        return "index";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if(user.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "Hello World!";
    }

    //查出一些数据在页面展示
    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好<h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        //classpath:/templates/success.html
        return "success";
    }
}
