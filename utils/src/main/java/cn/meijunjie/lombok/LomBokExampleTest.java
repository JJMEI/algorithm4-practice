package cn.meijunjie.lombok;

import lombok.extern.java.Log;

import java.util.function.Supplier;

@Log
public class LomBokExampleTest {

    public static void main(String[] args)
    {
        LomBokExample lomBokExample = new LomBokExample();
        lomBokExample.setUserName("dsdsd");
        lomBokExample.setPassword("dsdsdfvfv fn v");

        String result = lomBokExample.toString();
        System.out.println(result);


        LomBokExample lomBokExample1 = new LomBokExample("dsds","dsdsds");
        System.out.println(lomBokExample1.toString());
    }
}
