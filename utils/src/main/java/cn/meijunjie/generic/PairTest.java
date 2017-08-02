package cn.meijunjie.generic;

public class PairTest {

    public static void main(String[] args)
    {
        String[] words = {"Mary","dsd","sdsd","dsds"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println(mm.getFirst());
        System.out.println(mm.getSecond());

        System.out.println(ArrayAlg.getMiddle(words));

        Integer[] s = {1,2,3,4,3,54,5,4,54};

        System.out.println(ArrayAlg.getMiddle(s));
    }
}

class ArrayAlg
{
    public static Pair<String> minmax(String[] a)
    {
        if(a == null || a.length == 0)
            return  null;

        String min = a[0];
        String max = a[0];

        for(int i=1;i<a.length;i++)
        {
            if(min.compareTo(a[i]) > 0)
                min = a[0];
            if(max.compareTo(a[i]) < 0)
                max = a[0];
        }

        return  new Pair<String>(min,max);  //返回一个泛型类实例
    }

    //泛型方法,指定传入的来进行判断
    public static <T> T getMiddle(T[] array)
    {
        return array[array.length >> 1];
    }

    //限定泛型的类型，指定所接受类型的所属范围,这里就是限制为Comparable的子类 
    public static <T extends Comparable> Pair<T> minmax(T[] array)
    {
        if(array == null || array.length == 0)
            return null;

        T min = array[0];
        T max = array[0];

        for(int i=1;i<array.length;i++)
        {
            if(min.compareTo(array[i]) > 0)
                min = array[i];

            if(max.compareTo(array[i]) < 0)
                max = array[i];
        }

        return new Pair<T>(min,max);
    }
}
