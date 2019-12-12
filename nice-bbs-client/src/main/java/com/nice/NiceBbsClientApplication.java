package com.nice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.nice")
@MapperScan("com.nice.mapper")
public class NiceBbsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NiceBbsClientApplication.class, args);
    }

}
