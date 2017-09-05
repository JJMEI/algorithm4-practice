package cn.meijunjie.spider.test.service;

import cn.meijunjie.spider.constant.SysConstant;

import cn.meijunjie.spider.pool.SpiderThreadPool;
import cn.meijunjie.spider.service.SpiderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class TestSpiderServiceImpl {

    private static String url = null;
    private static Map<String,String> params = null;
    private static Map<String,String> headers = null;

//    @BeforeClass
    public static void testBefore()
    {
        url = SysConstant.BASE_URL;

        params = new HashMap<>();
        params.put("keyword","空调");
        params.put("wq","空调");
        params.put("enc","utf-8");



    }
//    @Test
//    public void test()
//    {
//        List<Runnable> list = new ArrayList<>();
//        for(int i=1;i<=100;i++)
//        {
//
//            int finalI = i;
//
//            list.add(new Runnable() {
//                @Override
//                public void run() {
//                    log.info("线程池执行");
//                    params.put("page",String.valueOf(finalI));
//                    SpiderServiceImpl.spiderData(url,null,params);
//                }
//            });
//
//        }
//
//        for(int i=0;i<list.size();i++)
//        {
//            new Thread(list.get(i)).start();
//        }
//
//    }

    public static void main(String[] args)
    {
        List<Runnable> list = new ArrayList<>();
        testBefore();
        for(int i=1;i<=100;i++)
        {

            int finalI = i;

            list.add(new Runnable() {
                @Override
                public void run() {
                    log.info("线程池执行");
                    params.put("page",String.valueOf(finalI));
                    SpiderServiceImpl.spiderData(url,null,params);
                }
            });

        }

        for(int i=0;i<list.size();i++)
            SpiderThreadPool.executorService.submit(list.get(i));
    }

}
