package cn.meijunjie.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JoinTest {

    static  int i=0;
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            public void run() {
                log.info(Thread.currentThread().getName());

                for(i=0;i<1000000;i++){}

            }
        });

        thread.start();
        //等待当前线程执行完毕，才继续执行
        thread.join();
        log.info(Thread.currentThread().getName());

        log.info("I的最终结果是 {}",i);
    }
}
