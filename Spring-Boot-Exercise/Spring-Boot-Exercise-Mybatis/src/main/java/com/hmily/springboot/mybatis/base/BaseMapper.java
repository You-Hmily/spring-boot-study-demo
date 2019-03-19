package com.hmily.springboot.mybatis.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by zyzhmily on 2019/3/19.
 */
//@NoRepositoryBean
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
