package com.kingsmartsi.config.mybatisPlus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import java.util.TimeZone;

/**
 * 程序注解配置
 *
 * @author kingsmartsi
 */
@Configuration
// 指定要扫描的Mapper类的包的路径
@MapperScan("com.kingsmartsi.**.mapper")
public class MyBatisPlusConfig {
    /**
     * 时区配置
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization() {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.timeZone(TimeZone.getDefault());
    }
}
