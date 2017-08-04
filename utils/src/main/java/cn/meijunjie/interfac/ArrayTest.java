package cn.meijunjie.interfac;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest {
    public static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if(!cl.isArray()) return null; //判断是不是一个数值类型，class表示数值对象类型

        Class componentType = cl.getComponentType(); //获取数值的类型
        int length = Array.getLength(a); //获取数组的长度

        Object newArray = Array.newInstance(componentType,length); //创建一个数组拷贝，传入类型参数，和长度

        System.arraycopy( a, 0, newArray,0, Math.min(length,newLength));
        //调用System.arraycopy()
        return newArray;
    }

    public static void main(String[] args)
    {
        int[] a = {13232,32,3,2,3,23,2,3};
        int[] b = (int[]) goodCopyOf(a,a.length);
    System.out.print(Arrays.toString(b));
    }
}
