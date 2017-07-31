package cn.meijunjie.fastjson;

import cn.meijunjie.commons.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestFastJson {

    static User user = new User();

    @Test
    public void testFastJsonSerialize()
    {
        user.setUsername("meijunjie");
        user.setPassword("123456");
        user.setAge(18);

        System.out.println(JSON.toJSONString(user));

        //序列化
        String objString = JSON.toJSONString(user);

        //反序列化
        User stringToObj = JSON.parseObject(objString, User.class);


        System.out.println(stringToObj.toString());
    }

    @Test
    public void testFastJsonSerializeArray()
    {
        User[] users = new User[2];

        User user1 = new User();
        user1.setAge(1);
        user1.setUsername("meijunjie");
        user1.setPassword("2e3213");

        users[0] = user1;

        User user2 = new User();
        user2.setPassword("2234");
        user2.setUsername("rewefwe");
        user2.setAge(232);

        users[1] = user2;

        System.out.println(JSON.toJSONString(users));

        //序列化
        String objString = JSON.toJSONString(users);

        //反序列化
        User[] stringToObj = JSON.parseObject(objString, User[].class);


        System.out.println(stringToObj[1].toString());

    }

    @Test
    public void testFastJsonSerializeList()
    {


        User user1 = new User();
        user1.setAge(1);
        user1.setUsername("meijunjie");
        user1.setPassword("2e3213");


        User user2 = new User();
        user2.setPassword("2234");
        user2.setUsername("rewefwe");
        user2.setAge(232);


        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);

        System.out.println(JSON.toJSONString(users));
    }


    @Test
    public void testFastJsonSerializeMap()
    {
        Map<String,User> maps = new HashMap<String, User>();

        User user1 = new User();
        user1.setAge(1);
        user1.setUsername("meijunjie");
        user1.setPassword("2e3213");


        User user2 = new User();
        user2.setPassword("2234");
        user2.setUsername("rewefwe");
        user2.setAge(232);

        maps.put("one", user1);
        maps.put("two", user2);

//        System.out.println(JSON.toJSONString(maps, SerializerFeature.BrowserCompatible));

        System.out.println(JSON.toJSONString(maps, SerializerFeature.UseSingleQuotes));
    }

}
