package cglib.proxy;

import jdk.proxy.PerformanceMonitor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz)
    {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        PerformanceMonitor.begin(o.getClass().getName()+"."+method.getName());

        Object result = methodProxy.invokeSuper(o,objects);

        PerformanceMonitor.end();

        return result;
    }
}
