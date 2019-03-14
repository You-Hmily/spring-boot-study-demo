package com.hmily.springboot.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zyzhmily on 2019/3/14.
 */
@Controller
public class JspDemoController {

    @RequestMapping("/index")
    public String demoIndex(){
        return "index";
    }

}
