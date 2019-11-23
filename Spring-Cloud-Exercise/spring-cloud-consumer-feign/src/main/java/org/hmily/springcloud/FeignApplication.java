package org.hmily.springcloud;


import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignApplication {


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class,args);
    }

}
