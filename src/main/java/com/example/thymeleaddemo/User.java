package com.example.thymeleaddemo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by meijunjie on 2017/9/3.
 */

/**
 * @Componet 该注解表明这是一个组件，便于后期依赖注入
 * @ConfigurationProperties 自动读取application.properties文件中的user属性
 * 在没有指定@ConfigurationProperties的情况下，可以通过@Value("${user.id}")来一个个指定属性，容易出错
 *
 *
 */
@Component
@ConfigurationProperties(prefix = "user")
@Setter
@Getter
public class User {
    private int id;
    private String username;
    private String password;
}
