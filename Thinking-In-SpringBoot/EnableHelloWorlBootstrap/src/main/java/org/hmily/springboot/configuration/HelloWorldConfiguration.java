package org.hmily.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld(){ //创建名为 “helloWorld”String 类型 Bean
        return "Hello,World";
    }



}
