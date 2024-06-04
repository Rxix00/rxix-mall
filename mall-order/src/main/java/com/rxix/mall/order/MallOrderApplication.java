package com.rxix.mall.order;

import com.rxix.mall.order.fegin.ProductService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * basePackageClasses 制定Feign接口的路径
 */
@EnableFeignClients(basePackageClasses = ProductService.class)
@EnableDiscoveryClient
@MapperScan("com.rxix.mall.order.dao")
@SpringBootApplication
public class MallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallOrderApplication.class, args);
    }

}
