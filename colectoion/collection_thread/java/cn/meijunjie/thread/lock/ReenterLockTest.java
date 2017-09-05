package cn.meijunjie.thread.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by meijunjie on 2017/8/31.
 */

@Slf4j
public class ReenterLockTest {

    //可重入锁🔐，必须显示获取和释放锁，与synchronized相比，synchronized是java的关键字 内建锁
    static ReentrantLock reentrantLock = new ReentrantLock();
    static int i=0;
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            public void run() {
                for(int j=0;j<100000;j++)
                {
                    reentrantLock.lock();
                    reentrantLock.lock();
                    try{
                        i++;
                    }finally {
                        reentrantLock.unlock();
                        reentrantLock.unlock();
                    }
                }

            }
        };

        Thread thread_1 = new Thread(runnable);
        Thread thread_2 = new Thread(runnable);

        thread_1.start();
        thread_2.start();

        thread_1.join();
        thread_2.join();

        log.info("i的值是多少: {}",i);


        Runnable runnable_tryLock = new Runnable() {
            public void run() {
                try
                {
                    log.info(Thread.currentThread().getName() +" : 我开始准备尝试获取🔐....超时时间5s "+ new Date().toLocaleString());
                    if(reentrantLock.tryLock(5, TimeUnit.SECONDS))
                    {
                        try {
                            log.info("当前获取🔐的线程 {}",Thread.currentThread().getName() + " " + new Date().toLocaleString());
                            log.info("准备休眠6s,马上开始...");
                            Thread.sleep(6000);
                            log.info("休眠结束.....");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else
                    {
                        log.info(Thread.currentThread().getName() + " : 我没有获取到🔐，因此必须要立即退出..."+new Date().toLocaleString());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    if(reentrantLock.isHeldByCurrentThread())
                        reentrantLock.unlock();
                }
            }
        };


        Thread thread_3 = new Thread(runnable_tryLock);
        Thread thread_4 = new Thread(runnable_tryLock);

        thread_3.start();
        thread_4.start();
    }
}
