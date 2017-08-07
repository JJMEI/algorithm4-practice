package cn.meijunjie.annotation;

public class FruitRun {

    public static void main(String[] args)
    {
        //运行时期是利用反射来实现的
        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}
