package test.threadlocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SimpleThreadLocal {

    private Map valueMap = Collections.synchronizedMap(new HashMap()); //获取一个线程安全的map

    public void set(Object newValue)
    {
        valueMap.put(Thread.currentThread(),newValue);
    }

    public Object get()
    {
        Thread thread = Thread.currentThread();
        Object o = valueMap.get(thread);

        if(o == null && valueMap.containsKey(thread))
        {
            o = initialValue();
            valueMap.put(thread,o);
        }
        return o;
    }

    public void remove()
    {
        valueMap.remove(Thread.currentThread());
    }

    public Object initialValue()
    {
        return null;
    }

}
