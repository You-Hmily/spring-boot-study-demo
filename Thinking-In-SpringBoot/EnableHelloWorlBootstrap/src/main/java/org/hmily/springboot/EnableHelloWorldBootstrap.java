package org.hmily.springboot;

import org.hmily.springboot.annotation.EnableHelloWorld;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@EnableHelloWorld
@Configuration
public class EnableHelloWorldBootstrap {

    public static void main(String[] args) {
        // 构建 Annotation 配置驱动Spring上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册当前引导类（被@Configuration标注）到Spring上下文
        context.register(EnableHelloWorld.class);
        // 启动上下文
        context.refresh();
        // 获取名称为“HelloWorld”的Bean 对象
        String helloWorld = context.getBean("helloWorld",String.class);
        System.out.printf("helloWorld = %s \n",helloWorld);
        // 关闭上下文
        context.close();
    }

}
