package cn.meijunjie.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.ArrayList;

@Slf4j
public class XMLConfigTest {

    public static void main(String[] args) throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        log.info(user.toString());

        log.info(sqlSession.toString());

        User user1 = new User();
        user1.setUsername("dsds");
        user1.setPassword("fdfdfd");
        mapper.insertUser(user1);

        ArrayList<User> list = new ArrayList<User>();

        for(int i=0;i<10;i++){
            User user2 = new User();
            user2.setUsername("dasds" + i);
            user2.setPassword("dsadsdasd" + i);
//
             list.add(user2);
        }

        mapper.insertUserList(list);
        try
        {
            sqlSession.commit();
            for(User u : list)
            {
                if(u.getId()==null)
                {
                    log.info("自增主键返回失败");
                }
                else
                {
                    log.info("自增主键为：" + u.getId().toString());
                }
            }

        }catch (Exception e)
        {
            sqlSession.rollback();
        }finally {
            //16:04:12.426 [main] DEBUG org.apache.ibatis.datasource.pooled.PooledDataSource - Returned connection 951880373 to pool.
            sqlSession.close();
        }

    }
}
