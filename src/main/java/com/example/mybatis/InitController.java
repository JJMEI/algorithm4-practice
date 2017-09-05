package com.example.mybatis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by meijunjie on 2017/9/5.
 */
@Controller
public class InitController {

    @RequestMapping("/mybatis")
    public String test()
    {
        return "MyBatisAJAX";
    }
}
