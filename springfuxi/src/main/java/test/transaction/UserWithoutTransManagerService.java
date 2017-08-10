package test.transaction;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserWithoutTransManagerService {



    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/jdbcwithouttx.xml");

        UserWithoutTransManagerService service = applicationContext.getBean("userService",UserWithoutTransManagerService.class);

        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

//        BasicDataSource basicDataSource = (BasicDataSource) applicationContext.getBean("dataSource");

        BasicDataSource basicDataSource = (BasicDataSource) jdbcTemplate.getDataSource();

        //检查数据源的autoCommit设置

        System.out.println("autoCommit: " + basicDataSource.getDefaultAutoCommit());

        //插入一条记录
        jdbcTemplate.execute("insert into t_user(user_name,password) values('meijunjie132','32242'); ");



        Integer id = jdbcTemplate.queryForObject("select user_id FROM  t_user where user_name='meijunjie132'",Integer.class);

        System.out.println(id);

        jdbcTemplate.execute("delete FROM  t_user where user_name='meijunjie132'");
    }
}
