package test.mybatis;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserMybatisTemplate {

    @Autowired
    @Qualifier(value = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;


}
