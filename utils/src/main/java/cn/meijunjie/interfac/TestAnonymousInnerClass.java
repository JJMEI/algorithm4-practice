package cn.meijunjie.interfac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TestAnonymousInnerClass {

    public void start(int interval, final boolean beep)
    {

        //匿名内部类的含义，创建某个接口的实现类的新对象，同时匿名内部类中 编译器默认添加了外部类的引用以及
        //想要访问变量的
        //匿名内部类实际上调用的是超类的后朝气
        ActionListener actionListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Date now = new Date();
                System.out.println("Now date is  " + now);
                if(beep)
                {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };

        Timer t = new Timer(interval,actionListener);
        t.start();
    }


    public static void main(String[] args)
    {
        TestAnonymousInnerClass lic = new TestAnonymousInnerClass();

        lic.start(1000,true);
        JOptionPane.showMessageDialog(null,"Quit please enter");
        System.exit(0);
    }

}
