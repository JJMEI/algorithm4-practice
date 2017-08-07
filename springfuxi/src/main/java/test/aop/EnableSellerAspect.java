package test.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EnableSellerAspect {

    /**
     * 引入新的接口为原有的
     */
    @DeclareParents(value = "test.aop.NaiveWaiter",defaultImpl = test.aop.SmartSeller.class)
    public Seller seller;


}
