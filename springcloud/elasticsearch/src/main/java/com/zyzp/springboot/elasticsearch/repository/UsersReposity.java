package com.zyzp.springboot.elasticsearch.repository;

import com.zyzp.springboot.elasticsearch.entity.Users;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersReposity extends ElasticsearchRepository<Users,String> {
    public Users getUsersByUsername(String username);
}
