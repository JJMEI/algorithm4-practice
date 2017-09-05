package com.example.thymeleaddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by meijunjie on 2017/9/3.
 */

@Service
public class UserService {

    @Autowired
    private User user;

    public User getUser()
    {
        return user;
    }
}
