package cn.meijunjie.reflect;

public class TestClass {

    public static void main(String[] args) throws ClassNotFoundException
    {
        String s = "hello";

        String className = s.getClass().getName();

        System.out.println(className);


        //一个Class对象包含了一个类的全部信息
        Class cl = Class.forName("java.util.Date");  //Class的静态方法forName()获得类名对应的Class对象

        System.out.println(cl.getName());

        //对于数组相关的对象 会有些特殊

        Double[] doubles = {32.23,3232.32};
        int[] ints = {323,43,4};

        String[] string = {"dsds","ddsds"};

        System.out.println(doubles.getClass().getName());
        System.out.println(ints.getClass().getName());
        System.out.println(string.getClass().getName());
    }
}
