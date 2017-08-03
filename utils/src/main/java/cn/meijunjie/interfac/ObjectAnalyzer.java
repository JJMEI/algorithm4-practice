package cn.meijunjie.interfac;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {

    private ArrayList<Object> visited = new ArrayList<Object>();

    public String toString(Object object) {

        if(object == null)
            return "null";
        if(visited.contains(object))
            return "....";

        Class cl = object.getClass(); //获取目标的class对象

        if(cl == String.class) return (String )object;

        if(cl.isArray()) //判断Class对象是不是数组类，如果是话进行数组类的相关操作
        {
            String r = cl.getComponentType() + "[]{"; //如果是数组类型的话，获取其类型

            for(int i = 0; i < Array.getLength(object); i++)  //获取数组对象的长度Array反射包中用于表示数组对象的类
            {
                if(i>0) r += ",";
                Object val = Array.get(object,i);  //返回指定数组对象中索引组件的值。如果该值是一个基本类型值，则自动将其包装在一个对象中。

                if(cl.getComponentType().isPrimitive()) r += val; //isPrimitive 用于判断是否为基本类型，8个基本类加一个void，如果是基本类型直接输出
                else  r += toString(val);  // 非基本类型，调用toString方法进行输出，这里涉及到了递归调用
            }
            return  r + "}";
        }

        String r = cl.getName();//获取class的类型名

        do{
            r += "[";
            Field[] fields = cl.getDeclaredFields(); //互货所有的非继承的字段

            AccessibleObject.setAccessible(fields,true); //绕过安全监测器，使得Field字段可访问

            for(Field field : fields)
            {
                if(!Modifier.isStatic(field.getModifiers())) //判断该字段是不是static的
                {
                    if(!r.endsWith("[")) r += ","; //判断r是不是以[结尾的，接下来直接获取field的字段名
                    r += field.getName() + "=";

                    try
                    {
                        Class t  = field.getType();//huoqu 字段所属类型

                        Object val = field.get(object);

                        if(t.isPrimitive()) r += val; //判断是否为基本数据类型
                        else r += toString(val); //递归声明
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        }while (cl != null);

        return r;
    }
}
