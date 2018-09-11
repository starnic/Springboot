package com.xian.springboot.mapper;

import com.sun.org.apache.bcel.internal.generic.RET;
import com.xian.springboot.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM department WHERE id = #{id}")
    public Department getDeptById(Integer id);

}
