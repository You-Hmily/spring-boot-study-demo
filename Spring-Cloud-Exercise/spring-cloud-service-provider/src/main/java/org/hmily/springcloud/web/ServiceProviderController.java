package org.hmily.springcloud.web;


import org.hmily.springcloud.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceProviderController {

    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/greeting")
    public String greeting(@RequestBody User user){
        return "Greeting,"+ user + "on port:"+ port;
    }

}
