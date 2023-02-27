package com.lixna.sgninsys;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lixna")
@MapperScan(basePackages = "com.lixna.sgninsys.mapper")
public class HnustWeb3Application8000 {

    public static void main(String[] args) {
        SpringApplication.run(HnustWeb3Application8000.class, args);
    }

}
