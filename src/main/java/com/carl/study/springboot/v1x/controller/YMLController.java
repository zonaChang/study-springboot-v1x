package com.carl.study.springboot.v1x.controller;

import com.carl.study.springboot.v1x.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc yml 配置属性
 * @Author changez
 * @Time 2018/11/11 12:15
 */
@RestController
@RequestMapping("/api/boot/yml/")
public class YMLController {

  @Value("${yml.key}")
  private String ymlValue;

  @Autowired
  private Student student;

  @RequestMapping("getStudentDefaultYml")
  public Student getStudentDefaultYml() {
    return student;
  }

  @RequestMapping("getYmlValue")
  private String getYmlValue(){
    return  ymlValue;
  }
}
