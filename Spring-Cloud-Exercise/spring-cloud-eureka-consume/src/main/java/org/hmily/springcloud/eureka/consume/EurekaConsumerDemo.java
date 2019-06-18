package org.hmily.springcloud.eureka.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaConsumerDemo {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerDemo.class,args);
    }

}
