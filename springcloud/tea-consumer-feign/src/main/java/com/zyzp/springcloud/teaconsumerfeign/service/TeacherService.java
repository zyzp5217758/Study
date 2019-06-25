package com.zyzp.springcloud.teaconsumerfeign.service;


import com.zyzp.springcloud.teaconsumerfeign.factory.MyFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "tea-provider",fallbackFactory = MyFactory.class)
public interface TeacherService {

    @GetMapping("/getDiscoveryClient/111")
    public DiscoveryClient getDiscoveryClient();
}
