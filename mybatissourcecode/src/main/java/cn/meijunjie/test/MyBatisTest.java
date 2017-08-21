package cn.meijunjie.test;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
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
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        ArrayList<User> userList = new ArrayList<User>();
        for(int i=0;i<10;i++)
        {
            User user = new User();
            user.setUsername("代号：————" + i);
            user.setPassword("密码：——————" + i);
            userList.add(user);
        }
        mapper.insertUserList(userList);

        try
        {
            sqlSession.commit();
            for(User user : userList)
                log.info("返回的自增主键是：---" + user.getId());
        }catch (Exception e)
        {
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }

    }

    @Test
    public void insertUserTest()
    {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("dsadfdsfdf    efbkewfkhwefvkh");
        user.setUsername("dasfsdfd");

        mapper.insertUser(user);
        try
        {
            sqlSession.commit();
            log.info("返回的自增主键是：---" + user.getId());
        }catch (Exception e)
        {
            sqlSession.rollback();
        }finally{
            sqlSession.close();
        }
    }


    @Test
    public void getBoardById()
    {
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        Board board = mapper.getBoardById(1);
        log.info("成功获取:...." + board.toString());
    }


    //一次查询 两个表 在一个sql语句中，将结果进行封装
    @Test
    public void getClassTest()
    {
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        Classes classes = mapper.getClass(1);
        log.info("一对一关联查询。。。" + classes.toString());
    }

    @Test
    public void getClass2Test()
    {
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        Classes classes = mapper.getClass2(1);
        log.info("一对一关联查询。。。" + classes.toString());
    }

    @Test
    public void getClass3Test()
    {
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        Classes classes = mapper.getClass3(1);
        log.info("一对一关联查询。。。" + classes.toString());
    }

    @Test
    public void getClass4Test()
    {
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        Classes classes = mapper.getClass4(1);
        log.info("一对一关联查询。。。" + classes.toString());
    }
}
