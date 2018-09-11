package com.xian.sprinboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 搭建基本环境
 * 1、导入数据库文件创建department表和employee表
 * 2、创建JavaBean封装数据
 * 3、整合mybatis操作数据库
 *      1.配置数据源信息
 *      2.使用注解版的Mybatis；
 *          1、@MapperScan指定需要扫描的mapper接口
 * 快速体验缓存
 *      步骤：
 *        1、开启基于注解的缓存 @EnableCaching
 *        2、标注缓存注解即可
 *              @Cacheable
 *              @CacheEvict
 *              @CachePut
 *
 *  默认使用的是ConcurrentMapCacheManager==concurrentMapCache 将数据保存在ConcurrentMap<Object, Object>中
 *  开发中使用缓存中间件； redis、 memcached、ehcache;
 *
 *  整合redis作为缓存
 *
 */
@MapperScan("com.xian.cache.mapper")
@SpringBootApplication
@EnableCaching
public class SprinbootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprinbootCacheApplication.class, args);
    }
}
