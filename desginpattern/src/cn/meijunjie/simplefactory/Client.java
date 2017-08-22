package cn.meijunjie.simplefactory;

import java.io.IOException;

public class Client {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
//        Api api = new Impl(); //这里只是体现了多态性，没有体现出接口的隔离性

        Api api = ApiFactory.createApi(); //实现了封装，对于用户而言 隔离了其内部实现
        api.output("hello world!");
    }
}
