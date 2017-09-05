package cn.meijunjie.thread;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VolatileTest {

    //volatile只保证它修饰变量的可见性，并不保证操作的原子性

    static Integer i = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            public void run() {

                synchronized (this){
                    for(int k=0;k<1000;k++)
                        i++;
                }

            }
        };

        Thread[] threads = new Thread[10];
        for(int i=0;i<10;i++)
        {
            threads[i] = new Thread(runnable);
            threads[i].start();
        }

        for(int i=0;i<10;i++)
        {
            threads[i].join();
        }



        log.info("最终输出的结果 i 是  {}",i);
    }
}
