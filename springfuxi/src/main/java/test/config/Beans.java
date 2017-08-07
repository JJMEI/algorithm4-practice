package test.config;

import cn.meijunjie.po.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 采用注解配置确实有点好处
 */
@Configuration
public class Beans {

    @Bean(name = "user")
    public User createUser()
    {
        User user = new User();

        user.setUserName("Meijunjie");
        user.setUserId(1213);

        return user;
    }
}
