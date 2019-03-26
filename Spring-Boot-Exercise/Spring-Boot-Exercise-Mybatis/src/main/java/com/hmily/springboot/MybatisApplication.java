package com.hmily.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by zyzhmily on 2019/3/18.
 */

@SpringBootApplication
//@MapperScan(basePackages = {"com.hmily.springboot.mybatis.user"})
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class,args);
    }

}
