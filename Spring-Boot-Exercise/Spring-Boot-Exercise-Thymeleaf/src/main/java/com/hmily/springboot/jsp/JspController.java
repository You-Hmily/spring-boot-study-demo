package com.hmily.springboot.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by zyzhmily on 2019/3/16.
 */
@Controller
public class JspController {

    @GetMapping("/testjsp")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("name","Hello JSP!!!");
        return "user";
    }

}
