package com.xian.springboot;

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
 *  1.按照redis;
 *  2.引入redis的starter
 *  3.配置redis
 *  4.测试缓存
 *       原理: CacheManager ==Cache 缓存组件来实际给缓存中存取数据
 *       1).引入redis的starter,容器中保存的是RedisCacheManager
 *       2).RedisCacheManager 帮我们创建RedisCache来作为缓存组件,redisCache通过操作redis缓存数据
 *       3).默认保存数据 k-v都是Object;利用序列化保存,如何保存为json
 *          1.引入redis的starter,cacheManager变为redisCacheManager;
 *          2.默认创建的redisCacheManager操作redis的时候使用jdk的序列化机制
 *          3.RedisTemplate<Object, Object>是默认使用jdk的序列化机制
 *       4).自定义CacheManager:
 */
@MapperScan("com.xian.cache.mapper")
@EnableCaching
@SpringBootApplication
public class SpringbootRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRedisApplication.class, args);
    }
}
