package com.itheima.myai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *
 * 服务启动类
 *
 */
@MapperScan("com.itheima.myai.mapper")
@SpringBootApplication
public class HeimaMyAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeimaMyAiApplication.class, args);
    }

}
