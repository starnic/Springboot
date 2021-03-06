package com.xian.springboot

import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class SpringBoot03LoggingApplicationTests {

    //记录器
    internal var logger = LoggerFactory.getLogger(javaClass)

    @Test
    fun contextLoads() {

        //日志的级别
        //由低到高  trace<debug<info<warn<error
        //可以调整输出的日志级别，日志就只会在这个级别以后的高级别生效；

        logger.trace("这是trace日志。。。")
        logger.debug("这是debug日志。。。")
        //springboot默认给我们使用的是info级别的,没有指定级别的就用默认级别：root级别
        logger.info("这是info日志。。。")
        logger.warn("这是warn日志。。。")
        logger.error("这是error日志。。。")
    }

}
