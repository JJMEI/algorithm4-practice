package cn.meijunjie.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapperTest {

    public static void main(String[] args)
    {
        MapperProxy proxy = new MapperProxy();

        UserMapper mapper = proxy.newInstance(UserMapper.class);

        User user  = mapper.getUserById(1001);

        log.info("ID is {}",user.getId());
        log.info("Name is {}",user.getUserName());
        log.info("Password is {}",user.getPassword());

        log.info(mapper.toString());
    }
}
