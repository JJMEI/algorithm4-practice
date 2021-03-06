package cn.meijunjie.innerclass;

class InnerClass
{
    protected  class Yolk
    {
        public Yolk(String string)
        {
            System.out.println("Innerclass.Yolk()" + "  " + string);
        }

        public void f()
        {
            System.out.println("InnerClass.Yolk.f()");
        }
    }

    public  InnerClass()
    {
        System.out.println("default constructor....");
    }
    public InnerClass(String string)
    {
        System.out.println("New InnerClass()  " + string);
    }

}
public class ExtendsInnerClass extends InnerClass
{

//    public class Yolk extends InnerClass.Yolk 可见即使父子类中相同的局部类也不会发生影响，因为他们在不同的命名空间中
    public class Yolk
    {
        public Yolk(String string)
        {
            System.out.println("ExtendsInnerClass.Yolk  " + string);
        }

        public void f()
        {
            System.out.println("ExtendsInnerClass.Yolk.f()");
        }
    }

    public ExtendsInnerClass()
    {
        System.out.println("default constructor......");
    }

    public ExtendsInnerClass(String string)
    {
        System.out.println("New ExtendsInnerClass  " + string);
    }

    public static void main(String[] args)
    {
        //先调用父类的构造器---> 再调用子类的构造器 完成子类的实例化，
        ExtendsInnerClass innerClass = new ExtendsInnerClass("hello");
        System.out.println("........");

        //我们这里明确了子类中的同名类Yolk是继承与父类中的同名Yolk,因此首先还是要调用父类的构造器，再调用本类的。
        innerClass.new Yolk("Str").f();
    }
}
