package cn.meijunjie.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class Test {
    public static void main(String[] args)
    {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/leeco/IdeaProjects/algorithm4-practice/mybatissourcecode");

        ((TargetClass) new MethondInterceptorImpl(new TargetClass()).createProxy()).test();

    }
}
