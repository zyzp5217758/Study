package com.zyzp.springboot.redisesrabbitmqsecurity.mapper;
import com.zyzp.springboot.redisesrabbitmqsecurity.entity.Students;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentsMapper {
    @Select("select * from Students where sid = #{sid}")
    public Students getStudentBySid(String sid);
}
