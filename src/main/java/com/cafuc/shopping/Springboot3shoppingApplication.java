package com.cafuc.shopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.cafuc.shopping.mapper")  //扫包
public class Springboot3shoppingApplication {

    @GetMapping("/")
    public String welcome(){
        return "hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(Springboot3shoppingApplication.class, args);
    }

}
