package com.hyc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.hyc.dao")
public class Shard3ManualApplication {

    public static void main(String[] args) {
        SpringApplication.run(Shard3ManualApplication.class, args);
    }

}
