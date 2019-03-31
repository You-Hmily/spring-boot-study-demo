package com.hmily.springboot.mybatis.user;


import com.hmily.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;


/**
 * Created by zyzhmily on 2019/3/19.
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
       List<User> getAllList();
}
