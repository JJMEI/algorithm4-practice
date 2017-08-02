package cn.meijunjie.interfac;


//想要创建一个代理对象，需要使用Proxy代理类的 newProxyInstance方法

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * 这个方法有三个参数 类加载器   目前用null表示默认的类加载器
 * Class对象数组，每个元素都是必须要实现的接口
 * 一个调用处理器
 */
public class TestProxy {

    public static void main(String[] args)
    {
        Object[] elements = new Object[1000];
        for(int i=0;i<elements.length;i++)
        {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler();
            Object proxy = Proxy.newProxyInstance(null,new Class[]{Comparable.class},handler);

            elements[i] = proxy;
        }

        Integer key = new Random().nextInt(elements.length)+1;
        int result = Arrays.binarySearch(elements,key);
        if(result >=0 )
        {
            System.out.println(elements[result]);
        }
    }

}

class TraceHandler implements InvocationHandler
{
    private Object target;
    public  TraceHandler(Object t)
    {
        target  = t;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(target);
        System.out.println(method.getName());

        if(args != null)
        {
            for(int i=0;i<args.length;i++)
            {
                System.out.println(args[i]);
                if(i<args.length-1)
                    System.out.println(". ");
            }
        }
        System.out.println("");
        return method.invoke(target,args);
    }
}