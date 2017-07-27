package cn.meijunjie.string;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringTest {

    public static void main(String[] args)
    {
//        String mango = "mango";
//
//        String s = "abc " + mango + " def " + 47;
//
//        String s = " ";
        Object o = new Object();
        StringBuilder s = new StringBuilder();
        for(int i = 1; i < 10;i++)
//            s += ""+i;
            s.append(" "+i);
        System.out.println(s.toString());



        System.out.println("-1323".matches("-?\\d+"));
        System.out.println("878".matches("-?\\d+"));
        System.out.println("+8798".matches("-?\\d+"));
        System.out.println("+22423".matches("(-|\\+)?\\d+"));


        String sentence = "Then, when you have found the shrubery. You must cut down the migha dasf fd2r 3r 2 r2  dfdf df sd  gsd s";
        System.out.println(Arrays.toString(sentence.split("\\.")));

        System.out.println(Arrays.toString(sentence.split("\\W")));

        System.out.println(Arrays.toString(sentence.split("\\w")));
        //java正则表达式 java.util.regex    Pattern Matcher 两个最重要的类

        Pattern pattern = "\\w{3,10}@\\w{3}\\.(com|cn|org|edu){1}";



    }
}
