package com.carl.study.springboot.v1x.controller;

import com.carl.study.springboot.v1x.model.model1.Student;
import com.carl.study.springboot.v1x.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc 学生类控制器
 * @Author changez
 * @Time 2018/11/9 17:27
 */
@RestController
@RequestMapping("/api/boot/student/")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @RequestMapping("getStuByName")
  public Student getStuByName(String name) {

    return studentService.getStuByName(name);
  }




}
