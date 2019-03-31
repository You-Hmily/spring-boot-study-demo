package com.hmily.springboot.config;

import com.hmily.springboot.entity.Person;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zyzhmily on 2019/3/31.
 */

//@Configuration
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = "person", name = "enabled", havingValue = "true")
@AutoConfigureAfter(EmbeddedWebServerFactoryCustomizerAutoConfiguration.class)
public class PersonAutoConfiguration {


    @ConfigurationProperties(prefix = "person")
    @Bean
    public Person person() {
        return new Person();
    }

//    @Bean
//    public PersonRestController personRestController(Person person) {
//        return new PersonRestController(person);
//    }
}