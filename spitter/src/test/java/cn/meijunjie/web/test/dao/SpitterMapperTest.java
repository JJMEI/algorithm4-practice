package cn.meijunjie.web.test.dao;

import cn.meijunjie.web.dao.Spitter;
import cn.meijunjie.web.dao.SpitterMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.Test;

import javax.annotation.Resource;

@Slf4j
//@Test
//@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/spring-dao.xml")
public class SpitterMapperTest {


    @Autowired
    private SpitterMapper spitterMapper;

    @org.junit.Test
    public void findSpitterByIdTest()
    {
        Spitter spitter = spitterMapper.findSpitterById(1);
        log.info(spitter.toString());
    }

    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
       Spitter spitter = applicationContext.getBean(SpitterMapper.class).findSpitterById(1);
       log.info(spitter.toString());

       Spitter spitter1 = applicationContext.getBean(SpitterMapper.class).findSpitterByUserName("meijunjie");
       log.info(spitter1.toString());
    }
}
