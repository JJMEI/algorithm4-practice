package cn.meijunjie.string;

import java.util.Arrays;
import java.util.regex.Matcher;
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

        String regex = "\\w{3,10}@\\w{3}\\.(com|cn|org|edu){1}";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(Pattern.matches(regex,"www.baidu.com"));

        Matcher matcher = pattern.matcher("meijunjie@163.com，asd，大厦，大厦，的，阿斯达，算法，额，发，f");

        String s1 = matcher.replaceAll("大厦");
        System.out.println(s1);

        if(matcher.find())
        {
            System.out.println("get it");
        }

        Matcher matcher1 = Pattern.compile("abc+").matcher("abc abcc ab ads dasd as adsdasda da");

        System.out.println(matcher1.groupCount());
        while(matcher1.find())
        {
            System.out.println(matcher1.group());
        }

        int i = 0;
        while(matcher1.find(i)) // i 表示搜索的 start search index
        {
            System.out.println(matcher1.group() + "  --> " + i);
            i++;
        }



    }
}
