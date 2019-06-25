package com.zyzp.springboot.elasticsearch.repository;

import com.zyzp.springboot.elasticsearch.entity.Students;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends ElasticsearchRepository<Students,String> {


}
