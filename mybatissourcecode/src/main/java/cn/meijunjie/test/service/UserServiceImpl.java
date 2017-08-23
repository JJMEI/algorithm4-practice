package cn.meijunjie.test.service;

import cn.meijunjie.test.User;
import cn.meijunjie.test.UserMapper;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        return userMapper.getUserById(id) ;
    }
}
