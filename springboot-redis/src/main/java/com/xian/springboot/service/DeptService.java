package com.xian.springboot.service;

import com.xian.springboot.bean.Department;
import com.xian.springboot.mapper.DepartmentMapper;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DeptService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = "dept")
    public Department getDeptById(Integer id) {

        System.out.println("查询部门" + id);
        Department department = departmentMapper.getDeptById(id);
        return department;
    }

}
