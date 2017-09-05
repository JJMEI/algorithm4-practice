package cn.meijunjie.thread;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SimpleWaitAndNotify {

    private static final Object object = new Object();


    public static void main(String[] args)
    {
        Thread thread_1 = new Thread(new Runnable() {
            public void run() {
                synchronized (object)
                {
                    log.info("我已经获取到锁，即将准备运行...");
                    try{
                        log.info("---->使该线程等待<----");
                        object.wait();
                    }catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    log.info("执行结束.....");

                }
            }
        });


        Thread thread_2 = new Thread(new Runnable() {
            public void run() {
                synchronized (object)
                {
                    try
                    {
                        log.debug("准备唤醒该线程");
                        object.notify();
                        log.debug("休眠2000mills");
                        Thread.sleep(2000);
                    }catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread_1.start();
        thread_2.start();
    }
}
