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

    /**
     * 冒泡排序 多躺比较和交换 消耗性能
     * @param array
     */
    public static void bubbleSort(int[] array)
    {
        if(array == null || array.length <= 1) {
            throw new IllegalArgumentException("传入数组参数异常。。。");
        }

        //总共循环arra.length - 1次
        for(int i = 1; i < array.length; i++)
        {
            //每一次循环确定一个最大的数
            for(int j = 0; j < array.length - i; j++)
            {
              if(array[j] > array[j+1])
              {
                  int temp = array[j+1]; //临时变量
                  array[j+1] = array[j];
                  array[j] = temp;
              }
            }
        }
    }

    public static void quickSort(int[] array)
    {


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
        int[] array = {12121,32,32,3,23,2,1,32,32,3,1,32,4343,32,32,32,43,4,5,35,310,9,8,7,6,5,4,3,2,1};

//        insertSort(array);R
//        System.out.println(showArrayElements(array));

//        shellSort(array);
       bubbleSort(array);
        System.out.println(showArrayElements(array));

    }
}
