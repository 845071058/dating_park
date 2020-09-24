package com.enjoy.dating_park;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@MapperScan("com.enjoy.dating_park.mapper")
public class DatingParkApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatingParkApplication.class, args);
    }

}
