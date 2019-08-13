package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.jk.dao")
@EnableCaching
public class SpringbootAnnotationProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAnnotationProviderApplication.class, args);
    }

}
