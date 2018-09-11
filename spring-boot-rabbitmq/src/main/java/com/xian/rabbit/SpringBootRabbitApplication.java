package com.xian.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 * 1、RabbitAutoConfiguration
 * 2、有自动配置了连接工厂ConnectionFactory
 * 3、RabbitProperties封装了rabbitmq的配置
 * 4、RabbitTemplate： 给rabbitmq发送和接收消息
 * 5、AmqpAdmin: RabbitMq管理功能组件
 */
@SpringBootApplication
public class SpringBootRabbitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitApplication.class, args);
    }
}
