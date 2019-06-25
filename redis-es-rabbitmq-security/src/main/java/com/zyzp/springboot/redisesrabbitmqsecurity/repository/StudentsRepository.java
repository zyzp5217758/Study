package com.zyzp.springboot.redisesrabbitmqsecurity.repository;

import com.zyzp.springboot.redisesrabbitmqsecurity.entity.Students;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends ElasticsearchRepository<Students,String> {

}
