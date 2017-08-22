package cn.meijunjie.simplefactory;

public class Impl implements Api{
    @Override
    public void output(String message) {
        System.out.println("Output: " + message);
    }
}
