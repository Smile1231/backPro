package com.zys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zys.dao")
public class MiniProgrammeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniProgrammeApplication.class, args);
    }

}
