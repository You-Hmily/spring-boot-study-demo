package org.hmily.spring.action.IOC_or_DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCandDIDemo {


    public static void main(String[] args) {
        //构造器注入
        constractInject();
    }


    //构造器注入
    private static void constractInject(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("knights.xml");
        Knight knight= (Knight) applicationContext.getBean("knight");
        knight.embarkOnQuest();
    }

}
