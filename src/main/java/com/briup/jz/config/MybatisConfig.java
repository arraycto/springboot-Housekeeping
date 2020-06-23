package com.briup.jz.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.briup.jz.dao")
public class MybatisConfig {
}
