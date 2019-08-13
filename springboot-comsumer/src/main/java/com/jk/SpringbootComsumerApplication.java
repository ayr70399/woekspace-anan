package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ImportResource("spring-dubbo-consumer.xml")
@EnableScheduling
@EnableTransactionManagement
public class SpringbootComsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootComsumerApplication.class, args);
    }

}
