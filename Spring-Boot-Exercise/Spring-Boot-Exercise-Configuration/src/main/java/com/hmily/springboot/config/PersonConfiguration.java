package com.hmily.springboot.config;

import com.hmily.springboot.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by zyzhmily on 2019/3/31.
 */
@Configuration
public class PersonConfiguration {

    @Bean
    @Profile("test")
    public Person zhangxueyou(){
        Person person=new Person();
        return person;
    }




}
