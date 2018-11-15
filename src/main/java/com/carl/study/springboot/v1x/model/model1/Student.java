package com.carl.study.springboot.v1x.model.model1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Desc 学生类信息
 * @Author changez
 * @Time 2018/11/9 17:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "student")
@Component
public class Student {

  private int id;
  private String name;
  private String className;
  private int age;
}
