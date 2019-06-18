package org.hmily.springcloud.eureka.provide.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hmily")
public class ProvideController {

    @GetMapping("/provider")
    public String provider(){
        return "Hello world!!";
    }

}
