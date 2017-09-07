package com.bee.redisflag.config;

import com.bee.redisflag.core.SystemInitializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by meijunjie on 2017/9/3.
 */
@Slf4j
public class MyApplicationStartedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Spring ContextRefreshed!");
        SystemInitializer systemInitializer = new SystemInitializer(event.getApplicationContext());
        try {
            systemInitializer.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
