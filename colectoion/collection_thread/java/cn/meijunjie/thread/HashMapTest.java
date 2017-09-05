package cn.meijunjie.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by meijunjie on 2017/8/31.
 */

@Slf4j
public class HashMapTest {

    //HashMap本身也是线程不安全的，多个线程去访问
    static HashMap<String,String> hashMap = new HashMap<String, String>();
//    static Map<String,String> hashMap = new ConcurrentHashMap<String, String>();

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            public void run() {
                for(int i=0;i<1000000;i++){
                    hashMap.put(Thread.currentThread().getName()+" key: "+i,"value: "+i);
                    log.info(Thread.currentThread().getName()+" key: "+i+" "+"value: "+i);
                }

            }
        };

        Thread thread_1 = new Thread(runnable);
        Thread thread_2 = new Thread(runnable);

        thread_1.start();
        thread_2.start();

        thread_1.join();
        thread_2.join();

        log.info("最终输出结果： " + HashMapTest.hashMap.size());
    }
}
