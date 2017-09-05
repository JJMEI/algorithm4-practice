package com.example.redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * Created by meijunjie on 2017/9/3.
 */

@Component
@ConfigurationProperties(prefix = "redis.cache")
@Getter
@Setter
public class RedisProperties {


    private int expireSeconds;
    private String cclusterNodes;
    private int commandTimeout;
}
