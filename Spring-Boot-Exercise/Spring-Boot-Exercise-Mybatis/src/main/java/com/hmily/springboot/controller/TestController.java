package com.hmily.springboot.controller;

import com.hmily.springboot.entity.User;
import com.hmily.springboot.mybatis.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zyzhmily on 2019/3/19.
 */
@Controller
public class TestController {


    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/test")
    @ResponseBody
    public List<User> dbTest() throws Exception {
        List<User> userList = userMapper.selectAll();
        return userList;
    }

}
