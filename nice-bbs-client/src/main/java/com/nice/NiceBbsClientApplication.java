package com.nice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.nice")
@MapperScan("com.nice.mapper")
@EnableScheduling
@EnableTransactionManagement(proxyTargetClass = true)
@EnableConfigurationProperties
public class NiceBbsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NiceBbsClientApplication.class, args);
    }

}
