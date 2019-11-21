package org.hmily.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    TestClient testClient;

    @GetMapping("/consumer")
    public String dc() {
       return testClient.consumer();
    }

}
