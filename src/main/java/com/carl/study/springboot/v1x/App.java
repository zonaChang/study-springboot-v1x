package com.carl.study.springboot.v1x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
@EnableAutoConfiguration //允许应用根据类路径下的jar包，自动配置项目
@ComponentScan
public class App {
  public static void main(String[] args) {

    //调用 run ，将业务委托给了Spring Boot
//    的SpringApplication类。SpringApplication将引导我们的应用，启动Spring，相应
//    地启动被自动配置的Tomcat web服务器
    SpringApplication.run(App.class, args);
    System.out.println("strar...");
  }

}
