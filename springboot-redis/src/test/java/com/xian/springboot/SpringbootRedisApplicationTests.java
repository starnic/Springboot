package com.xian.springboot;

import com.xian.springboot.bean.Employee;
import com.xian.springboot.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    RedisTemplate<Object, Employee> myRedisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;   //k-v字符串的

    @Autowired
    RedisTemplate redisTemplate;      //k-v都是对象的

    /**
     * redis常见的五大数据类型
     * String  list  set  hash zset
     *
     * stringRedisTemplate.opsForValue() [String字符串]
     * stringRedisTemplate.opsForList();  [list列表]
     * stringRedisTemplate.opsForSet();  [set集合]
     * stringRedisTemplate.opsForZSet();  [zset有序集合]
     * stringRedisTemplate.opsForHash();  [hash散列]
     */


    @Test
    public  void  test01(){

        //给redis保存一个数据
//        stringRedisTemplate.opsForValue().set("xian","123456");
//        stringRedisTemplate.opsForValue().append("xian","000");
//
//        System.out.println(stringRedisTemplate.opsForValue().get("xian"));

//        stringRedisTemplate.opsForList().leftPush("mylist","2");
//        List<String> mylist = stringRedisTemplate.opsForList().range("mylist", 0, -1);
//        for (String list:mylist) {
//            System.out.println(list);
//        }


    }

    @Test
    public void test02() {

        Employee empById = employeeMapper.getEmpById(1);

        //默认如果保存对象,使用jdk序列化机制,序列化后的数据保存到redis中
        //redisTemplate.opsForValue().set("emp-01",empById);

        //1.将数据以json的方式保存
        //(1),自己将对象转为json
        //(2),redisTemplate默认的序列化规则,改变默认的序列化规则


        myRedisTemplate.opsForValue().set("emp-0",empById);



        Object o = redisTemplate.opsForValue().get("emp-0");
        System.out.println(o);

    }



    @Test
    public void contextLoads() {

        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);


    }

}
