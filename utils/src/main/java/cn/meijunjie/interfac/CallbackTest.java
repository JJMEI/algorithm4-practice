package cn.meijunjie.interfac;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class CallbackTest {

    public static void main(String[] args)
    {
        ActionListener actionListener = new TimerPrinter();

        Timer t = new Timer(1000,actionListener);
        t.start();

        JOptionPane.showMessageDialog(null,"Quit prigram");

        System.out.println("已经促发了我马上种子。。。");
        System.exit(0);
    }
}

class TimerPrinter implements ActionListener
{

    public void actionPerformed(ActionEvent e) {
        Date now = new Date();
        System.out.println("At the one, the time is " + now);
        Toolkit.getDefaultToolkit().beep();
    }
}
