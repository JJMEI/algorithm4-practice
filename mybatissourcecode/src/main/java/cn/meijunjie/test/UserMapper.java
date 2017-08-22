package cn.meijunjie.test;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//mapper 接口
@Repository
public interface UserMapper {
    User getUserById(Integer id);
    void insertUser(User user);
    void insertUserList(ArrayList<User> list);
    int countAll();
    List<User> findAll();
    void updateUser(User user);
    void deleteUser(Integer id);
}
