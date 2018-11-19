package com.carl.study.springboot.v1x.model.model3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Desc 用户实体
 * @Author changez
 * @Time 2018/11/16 10:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private int id;
  private int age;
  private String name;

}
