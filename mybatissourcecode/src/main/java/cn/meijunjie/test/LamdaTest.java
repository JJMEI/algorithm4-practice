package cn.meijunjie.test;

public class LamdaTest {

    public static void main(String[] args)
    {
        Thread thread = ()->System.out.println("hello");
        thread.start();
    }

}
