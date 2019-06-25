package com.zyzp.springcloud.cfgbean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class StuRule extends AbstractLoadBalancerRule {

    public Server choose(ILoadBalancer lb, Object key) {
        if(lb==null){
            return null;
        }else{
            Server server = null;
            while (server==null){
                if(Thread.interrupted()){
                    return null;
                }
                List<Server> upServers = lb.getReachableServers();
                List<Server> allServers = lb.getAllServers();
                int count = allServers.size();
                if(count==0){
                    return null;
                }
                Random random = new Random(10);
                int i = random.nextInt()%count;
                server = upServers.get(i);
                if(server==null){
                    Thread.yield();
                }else {
                    if(server.isAlive()){
                        return server;
                    }
                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
