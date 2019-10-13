package com.spring.hello;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zyzhmily on 2018/5/6.
 */
public class Application {


    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MessagePrinter printer = applicationContext.getBean(MessagePrinter.class);
        printer.printMessage();
    }

}
