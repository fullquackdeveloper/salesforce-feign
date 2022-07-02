package com.fullquackdeveloper.salesforcefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SalesforceFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesforceFeignApplication.class, args);
    }

}
