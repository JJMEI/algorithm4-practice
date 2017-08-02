package cn.meijunjie.interfac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TestLocalInnerClass {

    public void start(int interval, final boolean beep)
    {
        class TimePrinter implements ActionListener
        {
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                System.out.println("At the tone, the time is " + now);
                if(beep)
                    Toolkit.getDefaultToolkit().beep();
            }
        }

        ActionListener actionListener = new TimerPrinter();
        Timer t = new Timer(interval,actionListener);
        t.start();
    }


    public static void main(String[] args)
    {
        TestLocalInnerClass lic = new TestLocalInnerClass();

        lic.start(1000,true);
        JOptionPane.showMessageDialog(null,"Quit please enter");
        System.exit(0);
    }

}
