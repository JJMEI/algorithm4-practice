package cn.meijunjie.cglibproxy;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//方法拦截器
@Slf4j
public class MethondInterceptorImpl implements MethodInterceptor {

    private TargetClass targetClass;

    public MethondInterceptorImpl(TargetClass targetClass) {
        this.targetClass = targetClass;
    }

    public Object createProxy()
    {
        Enhancer enhancer = new Enhancer(); //增强

        //为增强设置超类
        enhancer.setSuperclass(this.targetClass.getClass());
        //为增强设置回调函数
        enhancer.setCallback(this);


        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("切面方法A开始执行....");
        long start = System.currentTimeMillis();
        log.info("CurrentTime {}",start);
        for(int i=0;i<1000000;i++)
            method.invoke(this.targetClass,objects);
//            methodProxy.invokeSuper(this.getClass().getSuperclass(),objects); //这样会快一点

        log.info("Consumer Time {}",System.currentTimeMillis() - start );
        log.info("切面方法B开始执行.....");
        return null;
    }


}
