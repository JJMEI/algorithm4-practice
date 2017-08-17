package cn.meijunjie.jdkproxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 调用处理器实现类
 * 每次生成动态代理类对象时，都需要指定一个实现了InvocationHandler接口的调用处理器对象
 */
@Slf4j
public class InvocationHandlerImpl implements InvocationHandler {


    //要代理的真实对象
    private Object play;

    public InvocationHandlerImpl(Object play) {
        this.play = play;
    }

    /**
     * 该方法负责集中处理动态代理类上的所有方法调用
     * 调用处理器根据这三个参数进行预处理或分派到委托类实例上反射执行
     * @param proxy 代理类实例
     * @param method 被调用的方法对象
     * @param args   被调用方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        log.info("调用方法{}执行之前...",method.toString());

        //当代理对象调用真实对象的方法时，其会自动跳转到代理对象关联的handler对象的invoke方法来进行调用
        Object realValue = method.invoke(play,args);

        log.info("{}方法执行完毕.....",method.toString());
        return realValue;
    }


}
