package test.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class GreetingBeforeAdvice implements MethodBeforeAdvice {

    /**
     *
     * @param method        目标类方法
     * @param objects       目标方法入参
     * @param o             目标类实例
     * @throws Throwable
     */
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String clientName = (String) objects[0];

        System.out.println("How are you! Mr."+ clientName);

    }
}
