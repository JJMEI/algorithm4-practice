package cn.meijunjie.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

@Slf4j
public class PageHelperTest {

    public static void main(String[] args) throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//        PageHelper.startPage(12,100);
        List<User> list = mapper.findAll();
        for(User u : list)
            log.info(u.toString());

//        PageInfo<User> pageInfo = new PageInfo<User>(list);



    }
}
