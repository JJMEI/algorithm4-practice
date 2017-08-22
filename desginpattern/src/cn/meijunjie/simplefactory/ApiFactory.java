package cn.meijunjie.simplefactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApiFactory {

    //私有化构造方法，防止外界乱实例化
    private ApiFactory()
    {
    }

    //工程类封装了具体的实现类
    public static Api createApi() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Properties properties = new Properties();
        InputStream in = null;
        in = ApiFactory.class.getResourceAsStream("class.properties");
        properties.load(in);

        Api api = (Api) Class.forName(properties.getProperty("ImplClass")).newInstance();
        return api;
    }
}
