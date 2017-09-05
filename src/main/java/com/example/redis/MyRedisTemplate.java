package com.example.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;

/**
 * Created by meijunjie on 2017/9/3.
 */
@Slf4j
@Component
public class MyRedisTemplate {

    @Resource
    private JedisClusterConfig jedisClusterConfig;

    @Autowired
    private RedisProperties redisProperties;

    private static final String KEY_SPLIT = ":";




    //
    public void set(String prefix, String key, String value) throws Exception {
        jedisClusterConfig.getJedisCluster().set(prefix + KEY_SPLIT + key, value);
        log.info("RedisUtil:set cache key={},value={}", prefix + KEY_SPLIT + key, value);
    }

//    //已过期
//    public void setWithExpireTime(String prefix, String key, String value, int expireTime) {
//        jedisCluster.set(prefix + KEY_SPLIT + key, String.valueOf(expireTime), value);
//        log.info("RedisUtil:setWithExpireTime cache key={},value={},expireTime={}", prefix + KEY_SPLIT + key, value, expireTime);
//    }

    public void setWithexpireTime(String prefix, String key, String value) throws Exception {
        int EXPIRE_TIME = redisProperties.getExpireSeconds();
        jedisClusterConfig.getJedisCluster().setex(prefix + KEY_SPLIT + key, EXPIRE_TIME, value);
        log.info("RedisUtil:setWithExpireTime cache key={},value={},expireTime={}", prefix + KEY_SPLIT + key, value, EXPIRE_TIME);

    }

    //获取缓存
    public String get(String prefix,String key) throws Exception {
        String value = jedisClusterConfig.getJedisCluster().get(prefix+KEY_SPLIT+key);
        log.info("RedisUtil:get cache key={},value={}",prefix+KEY_SPLIT+key,value);
        return value;
    }

    public void deleteWithPrefix(String prefix,String key) throws Exception {
        jedisClusterConfig.getJedisCluster().del(prefix+KEY_SPLIT+key);
        log.info("RedisUtil:delete cache key={}",key+KEY_SPLIT+key);
    }
}