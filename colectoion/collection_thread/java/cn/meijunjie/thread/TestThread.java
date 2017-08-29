package cn.meijunjie.thread;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class TestThread {

    @Test
    public void testThread()
    {
        Runnable runnable = new Runnable() {
            public void run() {
                log.info("hello review thread...");
            }
        };

        Thread thread = new Thread(runnable);

        thread.start();
    }

    @Test
    public void test()
    {
        //Thread-0 在运行
        new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while(i < 100)
                    log.info(Thread.currentThread().getName() + ": "+i++);
            }
        }).start();

        //主线程 在运行
        int i = 100;
        while(i > 0)
            log.info(Thread.currentThread().getName() + ": " + i--);
    }
}
