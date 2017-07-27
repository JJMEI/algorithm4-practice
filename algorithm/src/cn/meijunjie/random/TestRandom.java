package cn.meijunjie.random;

import java.util.Random;
public class TestRandom {

    public static void main(String[] args)
    {
        Random random = new Random();

        random.setSeed(3);
        System.out.println(random.nextInt(43) +1);

        double randomInitial = Math.random();

        System.out.println(randomInitial);

        //== != 比较的是对象的引用

        Integer a = new Integer(47);
        Integer b = new Integer(47);

       System.out.println(a == b);
        System.out.println(a != b);


        System.out.println(a.equals(b));

        System.out.println(Math.PI);

        char c = 32;

        String s = Integer.toBinaryString(c);
        System.out.println(s);




    }


}
