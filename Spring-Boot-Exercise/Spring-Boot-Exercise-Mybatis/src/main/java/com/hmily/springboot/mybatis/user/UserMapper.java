package com.hmily.springboot.mybatis.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hmily.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * Created by zyzhmily on 2019/3/19.
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
