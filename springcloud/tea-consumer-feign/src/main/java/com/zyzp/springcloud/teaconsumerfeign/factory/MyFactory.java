package com.zyzp.springcloud.teaconsumerfeign.factory;

import com.zyzp.springcloud.teaconsumerfeign.service.TeacherService;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Repository;

@Repository
public class MyFactory implements FallbackFactory<TeacherService> {
    @Override
    public TeacherService create(Throwable throwable) {
        return new TeacherService() {
            @Override
            public DiscoveryClient getDiscoveryClient() {
                System.out.println("MyFactory");
                return null;
            }
        };
    }
}
