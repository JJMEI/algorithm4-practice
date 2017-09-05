package cn.meijunjie.spider.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by meijunjie on 2017/9/1.
 */
public class SpiderThreadPool {

    public static ExecutorService executorService = Executors.newFixedThreadPool(16);
}
