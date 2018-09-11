package com.xian.myrabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 * 1、RabbitAutoConfiguration
 * 2、有自动配置了连接工厂ConnectionFactory
 * 3、RabbitProperties封装了rabbitmq的配置
 * 4、RabbitTemplate： 给rabbitmq发送和接收消息
 * 5、AmqpAdmin: RabbitMq管理功能组件
 *      AmqpAdmin:创建和删除Queue. Exchange,Binding
 * 6、@EnableRabbit + @RabbitListener 监听消息队列的内容；
 */
@EnableRabbit    //开启基于注解的rabbitmq
@SpringBootApplication
public class MyrabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyrabbitmqApplication.class, args);
    }
}
