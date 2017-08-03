package cn.meijunjie.interfac;

import java.util.ArrayList;

public class VisitFieldTest {

    public static void main(String[] args)
    {
        ArrayList<Integer> squares = new ArrayList<Integer>();

        for(int i = 1; i < 5; i++)
        {
            squares.add(i*i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}

