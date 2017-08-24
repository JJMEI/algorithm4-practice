package cn.meijunjie.web.test.service;

import cn.meijunjie.web.service.SpitterService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-service.xml")
public class SpitterServiceTest {

    @Autowired
    private SpitterService spitterService;

    @Test
    public void test()
    {
        log.info(spitterService.findSpitter("habuma").toString());
    }

}
