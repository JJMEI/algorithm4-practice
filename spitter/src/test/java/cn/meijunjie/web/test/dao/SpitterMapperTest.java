package cn.meijunjie.web.test.dao;

import cn.meijunjie.web.dao.Spitter;
import cn.meijunjie.web.dao.SpitterMapper;
import cn.meijunjie.web.dao.Spittle;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//@Slf4j
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring/spring-dao.xml")
//public class SpitterMapperTest {
//
//
//    @Autowired
//    private SpitterMapper spitterMapper;
//
//    @Test
//    public void test()
//    {
//
//        log.info(spitterMapper.findSpitterByUserName("meijunjie").toString());
//
//        log.info("-------------------------");
//
//
//        log.info(spitterMapper.findSpitterById(1).toString());
//    }
//
//}

@Slf4j
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SpitterMapperTest extends AbstractTestNGSpringContextTests {


    @Autowired
    private SpitterMapper spitterMapper;

    @org.testng.annotations.Test
    public void test()
    {

        //        log.info(spitterMapper.findSpitterByUserName("meijunjie").toString());
        //
        //        log.info("-------------------------");
        //
        //
        //        log.info(spitterMapper.findSpitterById(1).toString());

        Spitter spitter = spitterMapper.findSpitterByUserName("habuma");

        Assert.assertNotNull(spitter);
        Assert.assertEquals("habuma",spitter.getUsername());
    }

    @Test
    public void addSpitterTest()
    {
        Spitter spitter = new Spitter();
        spitter.setUsername("meijunjie1");
        spitter.setPassword(".!dadhlas");
        spitter.setFullname("梅俊杰");
        spitter.setEmail("meijunjie@163.com");
        spitter.setUpdateByEmail(false);

        log.info(("生成测试Spitter实例"),spitter);

        spitterMapper.addSpitter(spitter);

        Assert.assertNotNull(spitterMapper.findSpitterByUserName("meijunjie"));
    }

    @Test
    public void findSpitterByIdTest()
    {
        Spitter spitter = spitterMapper.findSpitterById(4);

        Assert.assertNotNull(spitter);

        Assert.assertEquals("梅俊杰",spitter.getFullname());
    }

    @Test
    public void findAllSpittersTest()
    {
        List<Spitter> spitters = spitterMapper.findAllSpitters();

        Assert.assertNotNull(spitters);

        for(Spitter spitter : spitters)
        {
            log.info("spitter对象..." + spitter.toString());
        }
    }


    @Test
    public void getSpittersFromSpitter()
    {
        Spitter spitter = spitterMapper.findSpitterById(1);
        List<Spittle> spittles = spitterMapper.getSpittlesForSpitter(spitter);

        Assert.assertNotNull(spittles);

        for(Spittle spittle : spittles)
        {
            log.info(spittle.getId() +"\n"+ spittle.getSpittleText()+"\n"+spittle.getPostedTime());
        }
    }

    @Test
    public void getRecentSpittles()
    {
        List<Spittle> spittles = spitterMapper.getRecentSpittle(3);

        Assert.assertNotNull(spittles);
        for(Spittle spittle : spittles)
        {
            log.info("spittle_ID: " + spittle.getId());
            log.info("spittle_Test: " +spittle.getSpittleText());
            log.info("spittle_PostedTime: " + spittle.getPostedTime().toLocaleString());
        }
    }
}