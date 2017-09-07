package com.bee.redisflag.config;

import com.bee.redisflag.core.SystemDestroyer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * Created by meijunjie on 2017/9/3.
 */

@Slf4j
public class MyApplicationClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        log.info("Spring ContextClosed!");
        SystemDestroyer systemDestroyer = new SystemDestroyer(event.getApplicationContext());
        try {
            systemDestroyer.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
