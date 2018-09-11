package com.xian.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    //告诉spring这是一个异步方法
    @Async
    public void hello() {
        try {
            Thread.sleep(3000);
            System.out.println("处理数据中");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
