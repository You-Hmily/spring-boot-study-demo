package org.hmily.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
        return restTemplate.getForObject("http://spring-cloud-eureka-client/test", String.class);
    }

    public String fallback() {
        return "fallback";
    }

}
