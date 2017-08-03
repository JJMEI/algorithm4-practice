package cn.meijunjie.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest {


    // Class 对象包含了一个类的全部重要的信息
    public static void printConstructors(Class cl)
    {
        //从Class对象中获取所有的构造方法 无论是什么样的访问级别，但是不包括从父类继承过来的方法
        Constructor[] constructors = cl.getDeclaredConstructors();

        for(Constructor constructor : constructors)
        {
            String name = constructor.getName(); //获取构造器的名字
            System.out.print("  ");
            String modifiers = Modifier.toString(constructor.getModifiers()); //获取访问修饰符
            if(modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name+"(");

            Class[] paramTypes = constructor.getParameterTypes(); //获取参数类型的对象数组，参数类型用一个Class对象表示

            for(int j = 0; j < paramTypes.length; j++)
            {
                if(j>0)
                    System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    public static void printMethods(Class cl)
    {
        Method[] methods = cl.getDeclaredMethods();

        for(Method method : methods)
        {
            Class returnType = method.getReturnType();
            String name = method.getName();
            String modifiers = Modifier.toString(method.getModifiers());

            if(modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(returnType.getName()+ " " + "(");

            Class[] paramTypes = method.getParameterTypes();
            for(int j = 0; j<paramTypes.length;j++)
            {
                if(j>0)
                    System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");

        }
    }

    public static void printFields(Class cl)
    {

//        Field[] fields = cl.getDeclaredFields();
        Field[] fields = cl.getFields();
        for(Field field : fields)
        {
            Class fieldType = field.getType();
            String name = field.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(field.getModifiers());

            if(modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.println(name + " " + ";");
        }
    }
    public static void main(String[] args) throws Exception
    {
//        printConstructors(Class.forName("java.util.Date"));
//        printMethods(Class.forName("java.util.Date").getSuperclass());
//        printFields(Class.forName("java.util.Date"));

        String name;
        if(args.length > 0 )
        {
            name = args[0];
        }else
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name(e.g: java.util.name");
            name = in.next();
        }

        try
        {
            Class cl = Class.forName(name);

            Class superCl = cl.getSuperclass();

            String modfifiers = Modifier.toString(cl.getModifiers());

            if(modfifiers.length() > 0)
                System.out.print(modfifiers + " ");
            System.out.print("class" + name);

            if(superCl != null && superCl != Object.class)
                System.out.print("extends " + superCl.getName());

            System.out.print("\n{\n");
            printFields(cl);
            System.out.println();
            printConstructors(cl);
            System.out.println();
            printMethods(cl);
            System.out.println("}");

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
