package com.xian.sprinboot.service;

import com.xian.sprinboot.bean.Employee;
import com.xian.sprinboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames="emp")   //抽取缓存的公共配置
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果进行缓存；以后再要相同的数据，直接从缓存中获取，不用调用方法
     *
     *  CacheManager管理多个Cache组件的，对缓存的真正CRUD操作在Cache组件中，每一个缓存组件都有自己唯一一个名字
     * 几个属性：
     *      cacheNames/value: 指定缓存组件的名字
     *      key: 缓存数据使用的key： 可以用它来指定，默认是使用方法参数的值，1-方法的返回值
     *          编写SpEL: #id; 参数id的值  #a0 #p0 #root.args[0]
     *          key = "#id"
     *      keyGenerator: key的生成器；可以自己指定key的生成器的组件id
     *              key/keyGenerator: 二选一
     *      cacheManager: 指定缓存管理器； 或者cacheResolver指定缓存解析器
     *      condition： 指定符合条件的情况下才缓存，
     *              condition = "#id>0"  第一个参数>1的时候才进行缓存
     *      unless: 否定缓存； 当unless指定的条件为true，方法的返回值就不会被缓存，可以获取到结果进行判断
     *              unless = "#result == null"
     *              unless = "#a0 == 2"  如果第一个参数的值是2，结果不缓存
     *      sync: 是否使用异步模式，
     * 原理：
     *      1、自动配置类： CacheAutoConfiguration
     *      2、缓存的配置类
     *      3、那个配置类默认生效： simpleCacheConfiguration；
     *      4、给容器中注册了一个CacheManager： ConcurrentMapCacheManager
     *      5、可以创建COncurrentMapCache类型的缓存组件，它的作用将数据保存在ConcurrentMap中
     *
     * 运行流程
     * @Cacheable
     *      1、方法运行之前，先去查询Cache(缓存组件），按照cacheNames指定的名字获取
     *          (CacheManager先获取相应的缓存)，第一次获取缓存如果没有Cache组件会自动创建，
     *      2、去Cache中查找缓存的内容，使用一个key，默认就是方法的参数
     *      key是按照某种策略生成的，默认是使用keyGenerator生成key；
     *          SimpleKeyGenerator生成key的默认策略；
     *                  如果没有参数；key=new SimpleKey();
     *                  如果有一个参数； key=参数的值
     *                  如果有多个参数；key=new SimployeeKey(params);
     *      3、没有查到缓存就调用目标方法
     *      4、将目标方法返回的结果，奋进缓存中
     *
     *      @Cacheable标注的方法执行之前，先来检查缓存中有没有这个数据，默认按照参数的值作为key去查询缓存；
     *      如果没有就运行方法并将结果放入缓存；以后再来调用就可以直接使用缓存中的数据；
     *
     *      核心：
     *          1、使用CacheManager【ConcurrentMapCacheManager】按照名字得到cache(ConcurrentMap)
     *          2、key使用keyGenerator生成的，默认是SimpleKeyGenerator
     *
     *keyGenerator = "myKeyGenerator",condition = "#id>1",unless = "#a0 == 2"
     *
     * @param id
     * @return
     */
    @Cacheable(/*cacheNames = {"emp"}*//*,keyGenerator = "myKeyGenerator",condition = "#id>1",unless = "#a0 == 2"*/)
    public Employee getEmp(Integer id) {
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    /**
     * @CachePut: 既调用方法，又更新缓存数据；
     * 修改了数据库的某个数据，同时更新缓存；
     * 运行时机：
     *  1、先调用目标方法
     *  2、将目标方法的结果缓存起来
     *
     *  更新1号员工；【lastName：zhangsan;gender:0】
     *         将方法的返回值也放进缓存了；
     *         key；传入的employee对象  值：返回的employee对象
     *   查询1号员工
     *      应该是更新后的员工；
     *          key = "#employee.id": 使用传入的参数的员工id;
     *          key = "#result.id": 使用返回后的id
     * @Cacheable的key是不能用#result
     * 为什么没有更新钱的？【1号员工没有在缓存中更新】
     */
    @CachePut(value = "emp",key = "#result.id")
    public Employee updateEmpate(Employee employee) {
        System.out.println("updateEmp: "+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }


    /**
     * @CacheEvict: 缓存清除
     *  key: 指定要清除的数据
     *  allEntries: 清除所有缓存，默认false
     *  beforeInvocation = false：缓存的清除是否在方法之前执行
     *      默认代表缓存清除操作是在方法执行之后执行；如果出现异常，缓存就不会清除；
     *
     *  beforeInvocation = true：
     *      代表清除缓存操作实在方法运行之前执行，无论方法是否出现异常缓存都清除；
     *
     */
    @CacheEvict(/*value = "emp", */key = "#id")
    public void deleteEmp(Integer id) {
        System.out.println("deleteEmp:"+id);
        //employeeMapper.deleteEmpById(id);
    }

    /**
     * @Caching  定义赋值的缓存规则
     * @param lastName
     * @return
     */
    @Caching(
            cacheable = {
                @Cacheable(/*value = "emp",*/key = "#lastName")
            },
            put = {
                @CachePut(/*value = "emp",*/key = "#result.id"),
                @CachePut(/*value = "emp",*/key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName) {

        return employeeMapper.getEmpByLastName(lastName);
    }

}
