package cn.meijunjie.test;

import java.util.ArrayList;

//mapper 接口
public interface UserMapper {
    User getUserById(Integer id);
    void insertUser(User user);
    void insertUserList(ArrayList<User> list);
}
