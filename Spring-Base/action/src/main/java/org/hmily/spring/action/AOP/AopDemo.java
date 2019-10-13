package org.hmily.spring.action.AOP;

import org.hmily.spring.action.IOC_or_DI.Knight;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopDemo {

    public static void main(String[] args) {
        //构造器注入 并使用 AOP
        constractInject();
    }


    //构造器注入 并使用 AOP
    private static void constractInject(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("knights.xml");
        Knight knight= (Knight) applicationContext.getBean("knight");
        knight.embarkOnQuest();
    }

}
