package jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * InvocationHandler起到了将横切代码与目标类代码实现融合的一个过程，
 */

public class PerformanceHandler implements InvocationHandler {

    private Object target;

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy   proxy是最终生成的代理实例
     * @param method  method是被代理类实例的某个方法，通过它可以发起目标方法的反射调用
     * @param args    args是某个目标方法的入参，在反射时调用
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //横切代码
        PerformanceMonitor.begin(target.getClass().getName()+"."+method.getName());

        Object object = method.invoke(target,args);

        //横切代码
        PerformanceMonitor.end();

        return object;
    }
}
