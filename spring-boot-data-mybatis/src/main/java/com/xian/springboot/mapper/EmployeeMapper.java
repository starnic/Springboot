package com.xian.springboot.mapper;

import com.xian.springboot.bean.Employee;

//@Mapper或者@MapperScan将接口扫描到容器中
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}

