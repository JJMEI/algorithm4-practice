package cn.meijunjie.thread.chapter3;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread
    {
        public void run()
        {
            while(!ready)
                Thread.yield();
            log.info(String.valueOf(number));
        }
    }

    @Test
    public void testNoVisibility()
    {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }

    public static void main(String[] args)
    {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
