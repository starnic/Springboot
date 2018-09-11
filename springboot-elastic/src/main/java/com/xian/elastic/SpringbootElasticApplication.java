package com.xian.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot默认支持两种技术来和ES交互
 * 1、Jest(默认不生效)
 *  需要导入jest的工具包（io.searchbox.client.JestClient）
 * 2、springdata ElasticSearch 【Es 版本有可能不合适】
 *      如果版本不适配，
 *          1）、升级springboot版本
 *          2）、安装对应的ES
 *
 *      1)、Client节点信息clusterNodes; clusterName;
 *      2)、ElasticsearchTemplate 操作ES
 *      3）、编写一个ElasticsearchRepository的子接口来操作ES；
 *      两种用法：
 *          1、编写一个ElasticsearchRepository
 *
 */

@SpringBootApplication
public class SpringbootElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootElasticApplication.class, args);
    }
}
