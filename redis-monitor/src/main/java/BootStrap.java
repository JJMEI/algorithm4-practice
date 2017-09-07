import com.bee.redisflag.config.MyApplicationClosedEventListener;
import com.bee.redisflag.config.MyApplicationStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.velocity.VelocityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by meijunjie on 2017/9/3.
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.bee.redisflag"})
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,VelocityAutoConfiguration.class })
public class BootStrap {

    public static void main(String[] args)
    {
        SpringApplication springApplication = new SpringApplication(BootStrap.class);
        //应用启动监听，用于初始化redis连接
        springApplication.addListeners(new MyApplicationStartedEventListener());
        //应用结束监听，用于释放redis连接
        springApplication.addListeners(new MyApplicationClosedEventListener());
        springApplication.run(args);


    }
}
