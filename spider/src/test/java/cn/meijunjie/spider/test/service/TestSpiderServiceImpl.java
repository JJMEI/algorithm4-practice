package cn.meijunjie.spider.test.service;

import cn.meijunjie.spider.constant.SysConstant;
import cn.meijunjie.spider.service.SpiderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TestSpiderServiceImpl {

    private static String url = null;
    private static Map<String,String> params = null;
    private static Map<String,String> headers = null;

    @BeforeTest
    public void testBefore()
    {
        url = SysConstant.BASE_URL;

        params = new HashMap<>();
        params.put("keyword","乐视电视");
        params.put("wq","乐视电视");
        params.put("enc","utf-8");



    }
    @Test
    public void test()
    {
        for(int i=1;i<=100;i++)
        {
            params.put("page",String.valueOf(i));
            SpiderServiceImpl.spiderData(url,null,params);
        }

    }
}
