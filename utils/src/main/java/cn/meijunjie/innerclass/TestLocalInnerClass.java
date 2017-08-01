package cn.meijunjie.innerclass;

import javax.print.attribute.standard.Destination;

public class TestLocalInnerClass {

    public Destination destination(String s)
    {
        class PDestination implements Destination{
            private String label;

            private  PDestination(String whereTo)
            {
                label = whereTo;
            }

            public String readLabel()
            {
                return  label;
            }
        }

        return  new PDestination(s);
    }

    public static void main(String[] args)
    {
        TestLocalInnerClass testLocalInnerClass = new TestLocalInnerClass();
        Destination destination = testLocalInnerClass.destination("Tasmanid");
    }
}
