package com.ght.onlineeducation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.ght.onlineeducation.mapper")
@EnableTransactionManagement
public class OnlineEducationApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineEducationApplication.class, args);
    }

}
