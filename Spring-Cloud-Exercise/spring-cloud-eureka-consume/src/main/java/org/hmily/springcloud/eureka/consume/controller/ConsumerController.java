package org.hmily.springcloud.eureka.consume.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hmily")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String consumer(){
        return restTemplate.getForObject("http://localhost:8081/hmily/provider",String.class);
    }


    @GetMapping("/consumer1")
    public String consumer1(){
        return restTemplate.getForObject("http://hmily-provide/hmily/provider",String.class);
    }


}
