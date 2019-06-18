package com.hmily.springboot;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11Nio2Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.File;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Created by zyzhmily on 2019/3/15.
 */
@SpringBootApplication
public class EmbeddedWebContainerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmbeddedWebContainerApplication.class,args);
    }

    @Controller
    public static class MyController {

        @RequestMapping("/message")
        @ResponseBody
        public String message() {
            return "Hello,World";
        }


    }

    /**
     * Spring Boot 2.0 嵌入式 Web 容器实现
     */
    @Bean
    public static WebServerFactoryCustomizer webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer() {
            @Override
            public void customize(WebServerFactory factory) {
                if (factory instanceof TomcatServletWebServerFactory){
                    TomcatServletWebServerFactory tomcatServletWebServerFactory=TomcatServletWebServerFactory.class.cast(factory);

                    tomcatServletWebServerFactory.addContextCustomizers(new TomcatContextCustomizer() {
                        @Override
                        public void customize(Context context) {
                            context.setPath("/spring-boot");
                        }
                    });
                    tomcatServletWebServerFactory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
                        @Override
                        public void customize(Connector connector) {
                            connector=new Connector(Http11Nio2Protocol.class.getName());
                            connector.setPort(10222);
                        }
                    });

                }

            }
        };
    }

    /**
     * 1.5.4  嵌入式 Web 容器实现 Tomcat
     */
//    @Bean
//    public static EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
//        return new EmbeddedServletContainerCustomizer() {
//
//            @Override
//            public void customize(ConfigurableEmbeddedServletContainer container) {
//
//
//                if (container instanceof TomcatEmbeddedServletContainerFactory) {
//                    TomcatEmbeddedServletContainerFactory factory = TomcatEmbeddedServletContainerFactory.class.cast(container);
//
//                    factory.addContextCustomizers(new TomcatContextCustomizer() {
//                        @Override
//                        public void customize(Context context) {
//
//                            context.setPath("/spring-boot");
//                        }
//                    });
//
//                    factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
//                        @Override
//                        public void customize(Connector connector) {
//                            connector.setPort(8888);
//                            connector.setProtocol(Http11Nio2Protocol.class.getName());
//                        }
//                    });
//                }
//
//            }
//        };
//    }

}
