package com.yygh.cmn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName : ServiceCmnApplication  //类名
 * @Description :   //描述
 * @Author : 10079 //作者
 * @Date: 2022/6/2  20:33
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.yygh"})
public class ServiceCmnApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceCmnApplication.class, args);
    }
}
