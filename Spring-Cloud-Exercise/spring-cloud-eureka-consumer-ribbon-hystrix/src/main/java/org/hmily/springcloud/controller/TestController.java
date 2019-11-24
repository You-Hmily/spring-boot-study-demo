package org.hmily.springcloud.controller;

import org.hmily.springcloud.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {


    @Autowired
    TestService testService;

    @GetMapping("/consumer")
    public String dc() {
        return testService.consumer();
    }



}
