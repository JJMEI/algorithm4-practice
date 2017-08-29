package cn.meijunjie.spider.test.common;

import cn.meijunjie.spider.common.HttpClientUtils;
import cn.meijunjie.spider.constant.SysConstant;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TestHttpClientUtils {

    private static String url = null;
    private static Map<String,String> params = null;
    private static Map<String,String> headers = null;

    @BeforeTest
    public void testBefore()
    {
        url = SysConstant.BASE_URL;

        params = new HashMap<>();
        params.put("keyword","智能电视");
        params.put("wq","智能电视");
        params.put("enc","utf-8");


    }

    @Test
    public void testHttpGet()
    {
        log.info(HttpClientUtils.sendGet(url,null,params));
    }

}
