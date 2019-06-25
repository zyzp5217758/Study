package com.zyzp.springcloud.provider.mapper;

import com.entity.Students;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from students where sid = #{sid}")
    public Students getStudentBySid(String sid);

    @Select("select * from students")
    public List<Students> getAllStudents();
}
