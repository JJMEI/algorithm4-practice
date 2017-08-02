package cn.meijunjie.interfac;


import java.io.IOException;

/**
 * 深拷贝 就是克隆
 * 浅拷贝 就是平时经常用的复制
 */
public class CloneTest {

    public  static void main(String[] args) throws  CloneNotSupportedException
    {
        Employee employee = new Employee("hello",324.3);

        System.out.println(employee.toString());

        Employee copy = employee.clone();
        System.out.println(copy.toString());
        copy.setName("change copy.name...");


        System.out.println("original...." + employee.toString());
        System.out.println("after clone..." + copy.toString());




    }
}

/**
 * Cloneable 接口实际上是一个标记接口，实现了它就可以调用超类的clone方法对各个字段进行复制
 * 如果在没有实现 Cloneable 接口的实例上调用 Object 的 clone 方法，则会导致抛出 CloneNotSupportedException 异常。
 * 因此 需要重写父类的clone方法 因为你克隆的对象 只能是自己去调用
 */
class Employee implements Cloneable
{
     private String name;
     private double d;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", d=" + d +

                '}';
    }

    public Employee(String string, double d)
    {
        name = string;
        this.d = d;
    }

    public Employee clone() throws  CloneNotSupportedException
    {
        //调用超类的Object的clone(） 方法
        Employee employee = (Employee) super.clone(); //调用超类的方法对 各个字段进行复制
        return  employee;
    }

    public void close() throws IOException {

    }
}
