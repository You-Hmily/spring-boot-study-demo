package org.hmily.springboot.firstApplication;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = "org.hmily.springboot.firstApplication.config")
public class App {


    @RequestMapping("/firstApp")
    public String index(){
        return "Welcome,First App";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
