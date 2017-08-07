package test.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PreGreetingAspect {

    @Before("execution(* test.aop.Waiter.greetTo(..))")
    public void beforeGreeting()
    {
        System.out.println("How are you!");
    }
}
