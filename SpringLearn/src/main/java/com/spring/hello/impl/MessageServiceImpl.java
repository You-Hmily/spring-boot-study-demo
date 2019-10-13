package com.spring.hello.impl;

import com.spring.hello.MessageService;
import org.springframework.stereotype.Service;

/**
 * Created by zyzhmily on 2018/5/7.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Override
    public String getMessage() {
        return "hello Spring!!";
    }
}
