package com.xian.springboot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
object SpringBoot03LoggingApplication {

    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(SpringBoot03LoggingApplication::class.java, *args)
    }
}
