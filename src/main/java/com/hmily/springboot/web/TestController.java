package com.hmily.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by zyzhmily on 2018/4/23.
 */
@Controller
public class TestController {

    @RequestMapping("/webTest")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://www.baidu.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

    @RequestMapping("/helloTest")
    public String hello(Map<String,Object> map) {
        map.put("name", "SpringBoot1.5");
        return "hello";
    }

    /**
     * 返回html模板.
     */
    @RequestMapping("/helloFtl")
    public String helloFtl(Map<String,Object> map){
        map.put("hello","from TemplateController.helloFtl");
        return"helloFtl";
    }
}
