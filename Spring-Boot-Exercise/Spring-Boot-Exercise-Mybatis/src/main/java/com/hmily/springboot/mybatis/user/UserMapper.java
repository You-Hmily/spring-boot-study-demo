package com.hmily.springboot.mybatis.user;

import com.hmily.springboot.entity.User;
import com.hmily.springboot.mybatis.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zyzhmily on 2019/3/19.
 */
@Mapper
public interface UserMapper extends BaseMapper<User>{

    @Select("SELECT count(*) as totalRow FROM user")
    Integer gettotalRow();
}
