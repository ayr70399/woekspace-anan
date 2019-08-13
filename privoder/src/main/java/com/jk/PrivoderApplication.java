package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.jk.dao")
@EnableCaching
@ImportResource("spring-dubbo-provider.xml")
public class PrivoderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrivoderApplication.class, args);
    }

}
