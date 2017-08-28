package cn.meijunjie.collection;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.*;

@Slf4j
public class CollectionTest {

    @Test
    public void test()
    {
        ArrayList<String> list = new ArrayList<String>();


        list.add("dasd");
        list.add("dasdasdas");
        list.add("dasdas");

        ListIterator iterator = list.listIterator();
        while(iterator.hasNext())
        {
            log.info(iterator.next().toString()); //迭代然后 修改
            iterator.set("dsa");
            log.info(""+iterator.previousIndex());

        }

        log.info("for each ..... 迭代，只能读取不可修改");

        for(String s : list)
            log.info(s);
    }

    @Test
    public void testHashSet()
    {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("C");
        hashSet.add("dasbdkabdkbajdjadpjabcjbcjkabsjd");
        hashSet.add("D");
        hashSet.add("E");
        hashSet.add("F");
        hashSet.add("dasdasdasd");
        hashSet.add("iadgagsdhlchlahsld");
        hashSet.add("dasd2cad");

        for(String s : hashSet)
            log.info(s + "\n");
    }

    /**
     * 按字典顺序输出元素
     */
    @Test
    public void testTreeSet()
    {
        TreeSet<String> treeSet = new TreeSet<String>();

        treeSet.add("A");
        treeSet.add("1323");
        treeSet.add("dasdas");
        treeSet.add("dasdas12e23");

        for(String s : treeSet)
            log.info(s+"\n");
    }


    /**
     * 按插入顺序输出元素
     */
    @Test
    public void testLinkedHashSet()
    {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("A");
        linkedHashSet.add("1323");
        linkedHashSet.add("dascd22");

        for(String s : linkedHashSet)
            log.info(s);
    }

    @Test
    public void testPriorityQueue()
    {
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>();
        priorityQueue.add("sdasd");
        priorityQueue.add("dasdasda");
        priorityQueue.add("dasdasdasd");

        for (String s : priorityQueue)
            log.info(s);
    }

    @Test
    public void testTreeMap()
    {
        TreeMap<String,String> treeMap = new TreeMap<String, String>();


        treeMap.put("D","1");
        treeMap.put("F","2");
        treeMap.put("A","3");

        for(String s : treeMap.keySet())
            log.info(treeMap.get(s));
    }

    @Test
    public void testHashMap()
    {
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("A","1");
        hashMap.put("dascodohaoisd","ogufuwegfu");
        hashMap.put("bqiguq2324","fjasif903u39");
        hashMap.put("sda2232","dasdascoidjaij232j3");

        for(String s : hashMap.keySet())
            log.info(hashMap.get(s));

        for(Map.Entry<String,String> entry : hashMap.entrySet())
        {
            log.info(entry.getKey());
            log.info(entry.getValue());
            log.info("**************************************");

        }
    }

    @Test
    public void testLinkedHashMap()
    {
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put("A","a");
        linkedHashMap.put("B","b");
        for (String s : linkedHashMap.keySet())
            log.info(linkedHashMap.get(s));
    }
}
