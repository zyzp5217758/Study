package com.zyzp.springboot.elasticsearch.repository;

import com.zyzp.springboot.elasticsearch.entity.Authorize;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorizeReposity extends ElasticsearchRepository<Authorize,String> {
    public List<Authorize> getAuthorizesByUid(String uid);
}
