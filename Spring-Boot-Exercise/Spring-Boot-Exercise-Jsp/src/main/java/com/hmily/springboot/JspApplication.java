package com.hmily.springboot;

import com.hmily.springboot.filter.SpringBootFilter;
import com.hmily.springboot.listener.SpringBootListener;
import com.hmily.springboot.servlet.SpringBootServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


/**
 * Created by zyzhmily on 2019/3/14.
 */
@SpringBootApplication
//@ServletComponentScan(basePackages = {"com.hmily.springboot.servlet",
//                                      "com.hmily.springboot.filter",
//                                      "com.hmily.springboot.listener"})
public class JspApplication extends SpringBootServletInitializer {

    /**
     * 1、启动的地方先继承  SpringBootServletInitializer
     *
     * 2、组装 SpringApplicationBuilder
     *    使用其中的build方法。1.4 之后的版本。
     *   protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
                    builder.sources(JspApplication.class);
                    return builder;
                 }

     * 3、引入POM依赖
     * <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-web</artifactId>
     </dependency>

     <!--JSP 渲染引擎-->
     <dependency>
     <groupId>org.apache.tomcat.embed</groupId>
     <artifactId>tomcat-embed-jasper</artifactId>
     </dependency>
     <!--JSTL-->
     <dependency>
     <groupId>javax.servlet</groupId>
     <artifactId>jstl</artifactId>
     </dependency>

     <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-user</artifactId>
     <scope>user</scope>
     </dependency>
     *
     *4、加入相应的配置 WebMvcProperties
     * 在 spring-configuration-metadata.json
     *  路径前缀：spring.mvc.view.prefix
     *  资源后缀：spring.mvc.view.suffix
     *  添加 webapp
     *  打包为 war 包
     *  
     *
     *
     *
     * @param args
     */


    public static void main(String[] args) {
        SpringApplication.run(JspApplication.class,args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        builder.sources(JspApplication.class);
        return builder;
    }

//    @Bean
//    public  static ServletRegistrationBean servletRegistrationBean(){
//        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean();
//
//        servletRegistrationBean.setServlet(new SpringBootServlet());
//        servletRegistrationBean.addUrlMappings("/springBootServlet");
//        return servletRegistrationBean;
//
//    }
//
//    @Bean
//    public  static FilterRegistrationBean filterRegistrationBean(){
//        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
//
//        filterRegistrationBean.setFilter(new SpringBootFilter());
//        return filterRegistrationBean;
//
//    }
//
//    @Bean
//    public static ServletListenerRegistrationBean servletListenerRegistrationBean(){
//        ServletListenerRegistrationBean servletListenerRegistrationBean=new ServletListenerRegistrationBean();
//        servletListenerRegistrationBean.setListener(new SpringBootListener());
//        return servletListenerRegistrationBean;
//    }

}
