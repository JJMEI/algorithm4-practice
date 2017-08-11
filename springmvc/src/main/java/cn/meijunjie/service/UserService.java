package cn.meijunjie.service;

import cn.meijunjie.dao.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class UserService {

    @ModelAttribute("user")
    public User createUser(User user)
    {
        return user;
    }
}
