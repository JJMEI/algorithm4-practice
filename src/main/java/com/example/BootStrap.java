package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by meijunjie on 2017/9/3.
 */

@SpringBootApplication
@MapperScan(basePackages = {"com.example.mybatis"})
public class BootStrap {

    public static void main(String[] args)
    {
        SpringApplication.run(BootStrap.class,args);
    }
}
