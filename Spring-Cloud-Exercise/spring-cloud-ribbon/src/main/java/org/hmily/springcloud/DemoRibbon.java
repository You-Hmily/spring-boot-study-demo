package org.hmily.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
// 多个Ribbon定义
@RibbonClients({
        @RibbonClient(name = "spring-cloud-service-provider")
})
public class DemoRibbon {

    public static void main(String[] args) {
        SpringApplication.run(DemoRibbon.class,args);
    }

    // 声明 RestTemplate
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
