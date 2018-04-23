package com.hmily.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zyzhmily on 2018/4/23.
 * 首页控制器
 */
@RestController
public class IndexController {

    @RequestMapping("/hello")
    public String index(){
        return "Hello SpringBoot!!!";
    }

}
