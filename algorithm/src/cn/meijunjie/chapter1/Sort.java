package cn.meijunjie.chapter1;

public class Sort {

    /**
     * 最简单的插入排序
     * @param array
     */
    public static void insertSort(int[] array) {

        if(array == null || array.length <= 1) {
            throw new IllegalArgumentException("传入数组参数异常。。。");
        }

        for(int i = 1; i < array.length; i++) {
            int temp = array[i];
            int front = i - 1;

            while(front >= 0 && array[front] > temp) {
                array[front + 1] = array[front--];
            }
            array[front+1] = temp;
        }
    }

    /**
     * 希尔排序是插入排序的一种优化算法，主要采取了分段的插入算法，因此这里的gap的选择是十分重要的
     * @param array
     */
    public static void shellSort(int[] array)
    {
        if(array == null || array.length <= 1) {
            throw new IllegalArgumentException("传入数组参数异常。。。");
        }

        for(int gap = array.length >> 1; gap >0; gap >>= 1)
        {
            for(int i = gap; i < array.length; i += gap)
            {
                int temp = array[i];
                int front = i - gap;

                while(front >= 0 && array[front] > temp)
                {
                    array[front + gap] = array[front];
                    front -= gap;
                }

                array[front + gap] = temp;
            }
        }
    }

    public static String showArrayElements(int[] array)
    {
        if(array == null || array.length == 0)
            throw new IllegalArgumentException("数组参数异常。。。");

        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < array.length; i++)
            stringBuffer.append(array[i] + "  ");
        return stringBuffer.toString();
    }


    public static void main(String[] args)
    {
        int[] array = {11,24,43,545,43,4,35,4,54,3423,23,4,33434,432,343,23,43,4,3423423,43,43123};
//        insertSort(array);
//        System.out.println(showArrayElements(array));

        shellSort(array);
        System.out.println(showArrayElements(array));

    }
}
