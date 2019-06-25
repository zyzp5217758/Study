package com.zyzp.springboot.cache.config;

import com.zyzp.springboot.cache.entity.Students;
import com.zyzp.springboot.cache.entity.Teacher;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.lang.reflect.Method;
import java.util.Arrays;


@Configuration
public class MyConfig {

    @Bean
    public KeyGenerator myKeyGenerator(){
        return new KeyGenerator(){

            @Override
            public Object generate(Object o, Method method, Object... params) {
                return method.getName()+"zp"+ Arrays.asList(params);
            }
        };
    }
    @Bean
    public KeyGenerator myKeyGenerator01(){
        return new KeyGenerator(){

            @Override
            public Object generate(Object o, Method method, Object... params) {
                return "getStudents"+"zp"+ Arrays.asList(params);
            }
        };
    }
   @Bean
    public RedisCacheManager stuCacheManager(RedisConnectionFactory redisConnectionFactory){
       RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new Jackson2JsonRedisSerializer<Students>(Students.class)));
        RedisCacheManager cacheManager = RedisCacheManager.builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory)).cacheDefaults(redisCacheConfiguration).build();
        return cacheManager;
    }
   /* @Bean
    public RedisCacheConfiguration stuRedisCacheConfiguration(){
        Jackson2JsonRedisSerializer<Students> serializer = new Jackson2JsonRedisSerializer<Students>(Students.class);
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));
        return redisCacheConfiguration;
    }*/

   @Bean
   @Primary
   public RedisCacheManager teaCacheManager(RedisConnectionFactory redisConnectionFactory){
       RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
       redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new Jackson2JsonRedisSerializer<Teacher>(Teacher.class)));
       return RedisCacheManager.builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory)).cacheDefaults(redisCacheConfiguration).build();
   }
}
