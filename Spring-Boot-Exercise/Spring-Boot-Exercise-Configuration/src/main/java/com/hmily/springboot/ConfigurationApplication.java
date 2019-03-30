package com.hmily.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by zyzhmily on 2019/3/30.
 */
@SpringBootApplication
@ImportResource(locations = {"META-INF/spring/context.xml"})
public class ConfigurationApplication {

    public static void main(String[] args) {

        SpringApplication.run(ConfigurationApplication.class,args);
    }

}
