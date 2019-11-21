package org.hmily.springcloud.controller;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("spring-cloud-eureka-client")
public interface TestClient {


    @GetMapping("/test")
    String consumer();

}
