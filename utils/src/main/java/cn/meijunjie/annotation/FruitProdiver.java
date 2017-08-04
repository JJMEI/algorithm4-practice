package cn.meijunjie.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProdiver {

    public int id() default -1;
    public String name() default "";
    public String address() default "";

}
