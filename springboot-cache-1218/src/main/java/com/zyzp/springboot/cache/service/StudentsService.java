package com.zyzp.springboot.cache.service;


import com.zyzp.springboot.cache.entity.Students;
import com.zyzp.springboot.cache.mapper.StudentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@CacheConfig(cacheManager = "stuCacheManager",keyGenerator = "myKeyGenerator")
public class StudentsService {

    @Autowired
    private StudentsMapper studentsMapper;

    @Cacheable(cacheNames = {"stu3","stu4"},condition = "#root.args[0]>0",unless="#result==null",keyGenerator = "myKeyGenerator"/*,cacheManager = "stuCacheManager"*/)
    public Students getStudents(Integer sid){
        if(sid==1){
            return null;
        }
        return studentsMapper.getStudents();
    }

    @CacheEvict(cacheNames = "stu3",key = "#result.intValue()",/*keyGenerator = "myKeyGenerator01",*/beforeInvocation = false/*,cacheManager = "stuCacheManager"*/)
    public Integer delStudents(Integer sid){
        return studentsMapper.delStudents(sid);
    }

    @CachePut(cacheNames = "stu4",key="'getStudentszp[3]'"/*,cacheManager = "stuCacheManager"*/)
    public Students updateStudents(Students students){
        return studentsMapper.updateStudents(students);
    }

    @Caching(evict = {
            @CacheEvict(cacheNames = "stu3",key="'getStudentszp[3]'")
    },cacheable = {
            @Cacheable(cacheNames = "stu1",keyGenerator = "myKeyGenerator"/*,cacheManager = "stuCacheManager"*/),
            @Cacheable(cacheNames = "stu2",keyGenerator = "myKeyGenerator01"/*,cacheManager = "stuCacheManager"*/)
    },put = {
            @CachePut(cacheNames = "stu4",key="'getStudentszp[3]'"/*,cacheManager = "stuCacheManager"*/)
    }
    )
    public Students allMethod(Students students){
        return studentsMapper.updateStudents(students);
    }
}
