package com.bee.redisflag.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.bee.redisflag.core.GlobalInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Created by meijunjie on 2017/9/3.
 */

@Configuration
@Slf4j
public class MyWebMVCConfigurationAdapter extends WebMvcConfigurerAdapter {

    /*替换Spring默认的Jackson*/
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new FastJsonHttpMessageConverter());
    }

    /*配置全局的拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GlobalInterceptor()).addPathPatterns("/**");
    }

    /*Spring Boot 首页映射，未写死*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        String homePage = "";
        try {
            Properties props = PropertiesLoaderUtils.loadProperties(new ClassPathResource("application.properties"));
            homePage = props.getProperty("home.page");
        } catch (IOException e) {
            log.error(e.getMessage());
            homePage = "errors";
        }

        registry.addViewController("/").setViewName("redirect:" + homePage);
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    /*启用servlet内置handler处理机制(spring未配置的请求会forward至servlet，用于jsp等)*/
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Autowired
    private final ResourceLoader resourceLoader = new DefaultResourceLoader();
    // velocity视图解析器配置，使用支持布局的LayoutViewResolver
    @Bean
    public VelocityLayoutViewResolver velocityLayoutViewResolver() {
        VelocityLayoutViewResolver viewResolver = new VelocityLayoutViewResolver();
        viewResolver.setLayoutUrl("layout/default.vm");
        viewResolver.setPrefix("page/");
        viewResolver.setSuffix(".vm");
        viewResolver.setDateToolAttribute("datetool");
        viewResolver.setNumberToolAttribute("numbertool");
        viewResolver.setContentType("text/html;charset=UTF-8");
        return viewResolver;
    }

    @Bean
    public VelocityConfigurer VelocityConfigurer() {
        VelocityConfigurer configurer = new VelocityConfigurer();
        configurer.setResourceLoader(resourceLoader);
        configurer.setResourceLoaderPath("classpath:templates/");
        Properties properties = new Properties();
        properties.put(Velocity.VM_LIBRARY, "velocity/macro.vm");
        properties.put(Velocity.ENCODING_DEFAULT, "UTF-8");
        properties.put(Velocity.INPUT_ENCODING, "UTF-8");
        properties.put(Velocity.OUTPUT_ENCODING, "UTF-8");
        configurer.setVelocityProperties(properties);
        return configurer;
    }

}
