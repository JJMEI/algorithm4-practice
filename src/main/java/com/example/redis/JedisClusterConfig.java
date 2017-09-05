package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by meijunjie on 2017/9/3.
 */

/**
 * 该类使用了Java注解，@Configuration与@Bean，
 在方法上使用@Bean注解可以让方法的返回值为单例，
 该方法的返回值可以直接注入到其他类中去使用
 @Bean 注解是方法级别的
 如果使用的是常用的spring注解@Component，
 在方法上没有注解的话，方法的返回值就会是一个多例，
 该方法的返回值不可以直接注入到其他类去使用
 该方式的注解是类级别的
 */
@Component
public class JedisClusterConfig {

    @Autowired
    private RedisProperties redisProperties;


    public  JedisCluster getJedisCluster() throws Exception
    {
        String[] serverArray = redisProperties.getCclusterNodes().split(",");
        Set<HostAndPort>  nodes = new HashSet<>();

        for(String ipPort : serverArray)
        {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(),Integer.valueOf(ipPortPair[1].trim())));
        }
        return new JedisCluster(nodes,redisProperties.getCommandTimeout());
    }


}
