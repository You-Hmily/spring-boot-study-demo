package org.hmily.springcloud.ribbon;

import org.hmily.springcloud.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-provider.host}")
    private String serviceProviderHost;

    @Value("${service-provide.port}")
    private Integer serviceProviderPort;

    @Value("${service-provider.name}")
    private String serviceProviderName;

    @GetMapping("/hello")
    public String hello(){
        User user = new User();
        user.setId(1L);
        user.setName("hello");
        return restTemplate.postForObject("http://"+serviceProviderHost+":"+serviceProviderPort+"/greeting",user,String.class);
    }

}
