package com.hmily.springboot;

import com.hmily.springboot.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zyzhmily on 2018/5/8.
 * 拦截器
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport{

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DemoInterceptor()).addPathPatterns("/*");
        super.addInterceptors(registry);


    }


}
