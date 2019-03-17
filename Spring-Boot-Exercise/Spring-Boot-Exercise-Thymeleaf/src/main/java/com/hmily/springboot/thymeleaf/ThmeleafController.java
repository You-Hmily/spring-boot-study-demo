package com.hmily.springboot.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zyzhmily on 2019/3/16.
 */
@Controller
public class ThmeleafController {

    @RequestMapping(value = "/testthymeleaf")
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("thymeleaf");
        mv.addObject("name","欢迎使用Thymeleaf!");
        return mv;
    }


}
