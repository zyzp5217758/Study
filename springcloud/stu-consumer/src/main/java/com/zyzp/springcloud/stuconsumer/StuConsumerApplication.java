package com.zyzp.springcloud.stuconsumer;

import com.zyzp.springcloud.cfgbean.MyRuleConfig;
import com.zyzp.springcloud.cfgbean.StuRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RibbonClient(value = "stu-provider",configuration = MyRuleConfig.class)
public class StuConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuConsumerApplication.class, args);
    }

}

