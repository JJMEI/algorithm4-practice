package cn.meijunjie.thread.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by meijunjie on 2017/8/31.
 */

@Slf4j
public class ReadAndWriteLockTest {

    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    //读🔐
    public static Lock readLock = reentrantReadWriteLock.readLock();
    //写🔐
    public static Lock writeLock = reentrantReadWriteLock.writeLock();

    private int value;

    public Object handleReader(Lock lock)
    {
        try{
            lock.lock();
            Thread.sleep(1000); // 模拟读取操作
            log.info(Thread.currentThread().getName() + "：读取： " + String.valueOf(value));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            return value;
        }
    }


    public void handleWrite(Lock lock, int index) throws InterruptedException {
        try{
            lock.lock();
            Thread.sleep(1000); //模拟写操作
            value = index;
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args)
    {
        final ReadAndWriteLockTest readAndWriteLockTest = new ReadAndWriteLockTest();

        Runnable runnable_read = new Runnable() {
            public void run() {
                log.info(new Date().toLocaleString());
                readAndWriteLockTest.handleReader(ReadAndWriteLockTest.readLock);
//                readAndWriteLockTest.handleReader(ReadAndWriteLockTest.reentrantLock);
            }
        };

        Runnable runnable_write = new Runnable() {
            public void run() {
                try {
                    readAndWriteLockTest.handleWrite(ReadAndWriteLockTest.writeLock, new Random().nextInt());
                    readAndWriteLockTest.handleWrite(ReadAndWriteLockTest.reentrantLock, new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for(int i=0;i<100;i++)
        {
            new Thread(runnable_read).start();
            new Thread(runnable_write).start();
        }

    }

}
