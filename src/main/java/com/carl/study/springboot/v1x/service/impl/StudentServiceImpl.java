package com.carl.study.springboot.v1x.service.impl;

import com.carl.study.springboot.v1x.model.model1.Student;
import com.carl.study.springboot.v1x.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Desc 学生业务类
 * @Author changez
 * @Time 2018/11/9 17:29
 */
@Service
public class StudentServiceImpl implements StudentService{

  @Override
  public Student getStuByName(String name) {
    Student student = new Student();
    student.setId(new Random().nextInt(100));
    student.setName("name-"+name);
    return student;
  }
}
