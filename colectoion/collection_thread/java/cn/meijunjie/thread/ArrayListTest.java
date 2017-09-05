package cn.meijunjie.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by meijunjie on 2017/8/31.
 */

@Slf4j
public class ArrayListTest {

    //ArrayList是线程不安全的，内部缺少了锁保护，导致在扩容时内部一致性出现异常
//    static ArrayList<Integer> arrayList = new ArrayList<Integer>(10);
    static List<Integer> arrayList = Collections.synchronizedList(new ArrayList<Integer>());
    public static void main(final String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            public void run() {
                for(int i=0;i<10000;i++)
                    ArrayListTest.arrayList.add(i);
            }
        };

        Thread thread_1 = new Thread(runnable);
        Thread thread_2 = new Thread(runnable);

        thread_1.start();
        thread_2.start();

        thread_1.join();
        thread_2.join();

        log.info("最终输出结果： " + ArrayListTest.arrayList.size());

    }
}
