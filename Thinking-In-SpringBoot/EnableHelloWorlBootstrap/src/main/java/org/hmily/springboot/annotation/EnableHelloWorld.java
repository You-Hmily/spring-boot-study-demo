package org.hmily.springboot.annotation;


import org.hmily.springboot.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWorldConfiguration.class)// 导入 HelloWorldConfiguration
public @interface EnableHelloWorld {
}
