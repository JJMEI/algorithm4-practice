package cn.meijunjie.annotation;

import java.lang.reflect.Field;

public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clzz)
    {
        String strFruitName = "水果名称： ";
        String strFruitColor = "水果颜色：";
        String strFruitProvider = "供应商信息： ";

        Field[] fields = clzz.getDeclaredFields();

        for(Field field : fields)
        {
            if(field.isAnnotationPresent(FruitName.class)) //该字段是否被注解所修饰
            {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                strFruitName = strFruitName + fruitName.value();
                System.out.println(strFruitName);
            }
           else if (field.isAnnotationPresent(FruitColor.class))
            {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                strFruitColor = strFruitColor + fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            }
            if (field.isAnnotationPresent(FruitProdiver.class))
        {
            FruitProdiver fruitProdiver = field.getAnnotation(FruitProdiver.class);
            strFruitProvider = "供应商编号： " + fruitProdiver.id() + "供应商名称：" + fruitProdiver.name()+
                    "供应商地址： " + fruitProdiver.address();
            System.out.println(strFruitProvider);
        }
        }
    }
}
