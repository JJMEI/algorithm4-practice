package cn.meijunjie.test.service;

import cn.meijunjie.test.User;
import cn.meijunjie.test.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        return userMapper.getUserById(id) ;
    }
}
