//package com.example.mybatis;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.pool.DruidDataSourceFactory;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
///**
// * Created by meijunjie on 2017/9/3.
// */
//
//@Slf4j
//@Configuration
//public class MyBatisConfig {
//
//    @Autowired
//    private Environment environment;
//
//    @Bean(name = "dataSource")
//    public DataSource getDataSource() throws Exception
//    {
//        Properties properties = new Properties();
//        properties.put("driverClassName",environment.getProperty("jdbc.driveClassName"));
//        properties.put("url",environment.getProperty("jdbc.url"));
//        properties.put("username",environment.getProperty("jdbc.username"));
//        properties.put("password",environment.getProperty("jdbc.password"));
//
//        return DruidDataSourceFactory.createDataSource(properties);
//    }
//
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception
//    {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        return sqlSessionFactoryBean.getObject();
//    }
//}
