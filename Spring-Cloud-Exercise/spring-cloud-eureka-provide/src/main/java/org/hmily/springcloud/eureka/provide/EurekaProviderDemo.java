package org.hmily.springcloud.eureka.provide;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaProviderDemo {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderDemo.class,args);

    }

}
