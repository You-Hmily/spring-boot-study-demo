package com.hmily.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zyzhmily on 2018/8/28.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Demo {
    String code;
    String name;
}
