package com.example.thymeleaddemo;

import com.alibaba.fastjson.JSON;
import com.example.redis.MyConstants;
import com.example.redis.MyRedisTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by meijunjie on 2017/9/3.
 */
@RestController //该注解等价于 @Controller @ResponseBody JSON配置
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MyRedisTemplate myRedisTemplate;

    @RequestMapping("/getUser")
    public User getUser()
    {
        return userService.getUser();
    }


    @RequestMapping("/testJedisCluster")
    public User testJedisCluster(@RequestParam("username") String username) throws Exception {
        String value = myRedisTemplate.get(MyConstants.USER_FORWARD_CACHE_PREFIX,username);
        if(StringUtils.isBlank(value))
        {
            myRedisTemplate.set(MyConstants.USER_FORWARD_CACHE_PREFIX,username, JSON.toJSONString(getUser()));
            return null;
        }

        return JSON.parseObject(value,User.class);
    }
}
