package cn.meijunjie.interfac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class FieldInnerClassTest {
    public static void main(String[] args)
    {
        TalkingLock talkingLock = new TalkingLock(1000,true);
        talkingLock.start();

        JOptionPane.showMessageDialog(null,"quit");
        System.exit(0);
    }


}

class TalkingLock
{
    private  int interval;
    private boolean beep;

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public boolean isBeep() {

        return beep;
    }

    public void setBeep(boolean beep) {
        this.beep = beep;
    }

    public TalkingLock(int interval, boolean beep)
    {
        this.interval = interval;
        this.beep = beep;
    }

    public void start()
    {
        ActionListener actionListener = new TimerPrinter();
        Timer t = new Timer(1000,actionListener);
        t.start();
    }

    public class TimePrinter implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            Date now = new Date();
            System.out.println("At the one, the time is " + now);
            if(beep)
                Toolkit.getDefaultToolkit().beep();
        }
    }
}