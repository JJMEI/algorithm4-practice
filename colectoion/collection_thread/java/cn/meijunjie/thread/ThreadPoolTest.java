package cn.meijunjie.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by meijunjie on 2017/8/31.
 */

@Slf4j
public class ThreadPoolTest {

    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Runnable runnable = new Runnable() {
            public void run() {

                try
                {
                    log.info("当前正在执行的线程 {}",Thread.currentThread().getName());
                    Thread.sleep(1000);
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };

        for(int i = 0; i < 2500; i++)
            executorService.submit(runnable);
    }
}
