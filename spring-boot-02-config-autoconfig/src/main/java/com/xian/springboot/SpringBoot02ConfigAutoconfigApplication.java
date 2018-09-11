package com.xian.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpEncodingProperties;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;

@SpringBootApplication
public class SpringBoot02ConfigAutoconfigApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBoot02ConfigAutoconfigApplication.class, args);
    }
}
