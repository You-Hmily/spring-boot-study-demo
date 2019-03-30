package com.hmily.springboot.controller;

import com.hmily.springboot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zyzhmily on 2019/3/30.
 */
@RestController
public class DemoContoller implements EnvironmentAware{

    @Autowired
    @Qualifier("person")
    private Person person;

    @Value("${person.name}")
    private String name;

    private int age;

    @RequestMapping("/test")
    public Person getDemo(){
        return person;
    }

    @RequestMapping("/testAn")
    public String getDemoAn(){
        return name;
    }

    @RequestMapping("/testJavaCode")
    public Integer getDemoJavaCode(){
        return age;
    }


    @Override
    public void setEnvironment(Environment environment) {
          this.age=environment.getProperty("person.age",Integer.class);
    }
}
