package cn.meijunjie.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

@Slf4j
public class SecondeCacherTest {

    public static SqlSessionFactory sqlSessionFactory = null;

    public static void main(String[] args) throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();

        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);

        //11:45:32.996 [main] DEBUG cn.meijunjie.test.UserMapper - Cache Hit Ratio [cn.meijunjie.test.UserMapper]: 0.0
        //11:45:33.001 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Opening JDBC Connection
        //11:45:33.371 [main] DEBUG org.apache.ibatis.datasource.pooled.PooledDataSource - Created connection 1902260856.
        //11:45:33.372 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Setting autocommit to false on JDBC Connection [com.mysql.jdbc.JDBC4Connection@71623278]
        //11:45:33.378 [main] DEBUG cn.meijunjie.test.UserMapper.getUserById - ==>  Preparing: SELECT * FROM USER WHERE id = ?
        //11:45:33.434 [main] DEBUG cn.meijunjie.test.UserMapper.getUserById - ==> Parameters: 222(Integer)
        //11:45:33.453 [main] DEBUG cn.meijunjie.test.UserMapper.getUserById - <==      Total: 1
        //11:45:33.454 [main] INFO cn.meijunjie.test.SecondeCacherTest - User(id=222, username=dasds198, password=dsadsdasd198)
        //11:45:33.463 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Resetting autocommit to true on JDBC Connection [com.mysql.jdbc.JDBC4Connection@71623278]
        //11:45:33.463 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@71623278]
        //11:45:33.466 [main] DEBUG org.apache.ibatis.datasource.pooled.PooledDataSource - Returned connection 1902260856 to pool.
        //11:45:33.527 [main] DEBUG cn.meijunjie.test.UserMapper - Cache Hit Ratio [cn.meijunjie.test.UserMapper]: 0.5
        //11:45:33.527 [main] INFO cn.meijunjie.test.SecondeCacherTest - User(id=222, username=dasds198, password=dsadsdasd198)
        //11:45:33.528 [main] DEBUG cn.meijunjie.test.UserMapper - Cache Hit Ratio [cn.meijunjie.test.UserMapper]: 0.6666666666666666
        //11:45:33.528 [main] INFO cn.meijunjie.test.SecondeCacherTest - User(id=222, username=dasds198, password=dsadsdasd198)
        User user1 = mapper1.getUserById(222);
        log.info(user1.toString());
        sqlSession1.close(); //写入到缓存中

        //第二次查询的时候会从UserMapper缓存中去取。。
        User user2 = mapper2.getUserById(222);
        log.info(user2.toString());

        //实现增删改操作后，二级缓存中的内容就会被清空
//        User user = mapper2.getUserById(121);
//        user.setUsername("sdasdasd");
//        mapper2.updateUser(user);
//        sqlSession2.commit();
//        sqlSession2.close();

        //第三次查询直接从数据库获取
        User user3 = mapper3.getUserById(222);
        log.info(user3.toString());

        /**
         * 11:53:08.757 [main] DEBUG cn.meijunjie.test.UserMapper - Cache Hit Ratio [cn.meijunjie.test.UserMapper]: 0.0
         11:53:08.763 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Opening JDBC Connection
         11:53:09.074 [main] DEBUG org.apache.ibatis.datasource.pooled.PooledDataSource - Created connection 1902260856.
         11:53:09.074 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Setting autocommit to false on JDBC Connection [com.mysql.jdbc.JDBC4Connection@71623278]
         11:53:09.079 [main] DEBUG cn.meijunjie.test.UserMapper.getUserById - ==>  Preparing: SELECT * FROM USER WHERE id = ?
         11:53:09.125 [main] DEBUG cn.meijunjie.test.UserMapper.getUserById - ==> Parameters: 222(Integer)
         11:53:09.154 [main] DEBUG cn.meijunjie.test.UserMapper.getUserById - <==      Total: 1
         11:53:09.155 [main] INFO cn.meijunjie.test.SecondeCacherTest - User(id=222, username=dasds198, password=dsadsdasd198)
         11:53:09.168 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Resetting autocommit to true on JDBC Connection [com.mysql.jdbc.JDBC4Connection@71623278]
         11:53:09.170 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@71623278]
         11:53:09.172 [main] DEBUG org.apache.ibatis.datasource.pooled.PooledDataSource - Returned connection 1902260856 to pool.
         11:53:09.234 [main] DEBUG cn.meijunjie.test.UserMapper - Cache Hit Ratio [cn.meijunjie.test.UserMapper]: 0.5
         11:53:09.234 [main] INFO cn.meijunjie.test.SecondeCacherTest - User(id=222, username=dasds198, password=dsadsdasd198)
         11:53:09.234 [main] DEBUG cn.meijunjie.test.UserMapper - Cache Hit Ratio [cn.meijunjie.test.UserMapper]: 0.3333333333333333
         11:53:09.234 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Opening JDBC Connection
         11:53:09.234 [main] DEBUG org.apache.ibatis.datasource.pooled.PooledDataSource - Checked out connection 1902260856 from pool.
         11:53:09.234 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Setting autocommit to false on JDBC Connection [com.mysql.jdbc.JDBC4Connection@71623278]
         11:53:09.235 [main] DEBUG cn.meijunjie.test.UserMapper.getUserById - ==>  Preparing: SELECT * FROM USER WHERE id = ?
         11:53:09.235 [main] DEBUG cn.meijunjie.test.UserMapper.getUserById - ==> Parameters: 121(Integer)
         11:53:09.236 [main] DEBUG cn.meijunjie.test.UserMapper.getUserById - <==      Total: 1
         11:53:09.236 [main] DEBUG cn.meijunjie.test.UserMapper.updateUser - ==>  Preparing: update user set username=?,password=? where id=?
         11:53:09.236 [main] DEBUG cn.meijunjie.test.UserMapper.updateUser - ==> Parameters: sdasdasd(String), dsadsdasd99(String), 121(Integer)
         11:53:09.237 [main] DEBUG cn.meijunjie.test.UserMapper.updateUser - <==    Updates: 1
         11:53:09.237 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Committing JDBC Connection [com.mysql.jdbc.JDBC4Connection@71623278]
         11:53:09.239 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Resetting autocommit to true on JDBC Connection [com.mysql.jdbc.JDBC4Connection@71623278]
         11:53:09.239 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@71623278]
         11:53:09.240 [main] DEBUG org.apache.ibatis.datasource.pooled.PooledDataSource - Returned connection 1902260856 to pool.
         11:53:09.240 [main] DEBUG cn.meijunjie.test.UserMapper - Cache Hit Ratio [cn.meijunjie.test.UserMapper]: 0.25
         11:53:09.240 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Opening JDBC Connection
         11:53:09.240 [main] DEBUG org.apache.ibatis.datasource.pooled.PooledDataSource - Checked out connection 1902260856 from pool.
         11:53:09.240 [main] DEBUG org.apache.ibatis.transaction.jdbc.JdbcTransaction - Setting autocommit to false on JDBC Connection [com.mysql.jdbc.JDBC4Connection@71623278]
         11:53:09.240 [main] DEBUG cn.meijunjie.test.UserMapper.getUserById - ==>  Preparing: SELECT * FROM USER WHERE id = ?
         11:53:09.240 [main] DEBUG cn.meijunjie.test.UserMapper.getUserById - ==> Parameters: 222(Integer)
         11:53:09.241 [main] DEBUG cn.meijunjie.test.UserMapper.getUserById - <==      Total: 1
         11:53:09.241 [main] INFO cn.meijunjie.test.SecondeCacherTest - User(id=222, username=dasds198, password=dsadsdasd198)

         */
    }
}
