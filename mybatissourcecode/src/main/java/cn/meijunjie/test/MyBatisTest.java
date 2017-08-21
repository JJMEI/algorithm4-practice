package cn.meijunjie.test;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Slf4j
public class MyBatisTest {
    private static SqlSession sqlSession = null;

    @BeforeTest
    public void beforeTest() throws IOException {
        sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml")).openSession();
    }

    @Test
    public void updateUserTest()
    {
        User user = new User(1,"2424","3434");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUserTest()
    {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(1);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void getUserByIdTest()
    {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(222);
        log.info("获取到的user..." + user.toString());
    }

    @Test
    public void getUserAllTest()
    {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.findAll();
        for(User user : list)
        {
            log.info("详细信息如下：....." + user.toString());
        }
    }

    /**
     * 批量插入并返回自增主键
     */
    @Test
    public void batchInsertUserTest()
    {

    }
}
