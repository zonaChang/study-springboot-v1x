package com.carl.study.springboot.v1x.mapper.mapperDB1;

import com.carl.study.springboot.v1x.model.model1.Student;
import com.carl.study.springboot.v1x.model.model2.KHInfo;

/**
 * @Desc 学生类mapper
 * @Author changez
 * @Time 2018/11/13 13:10
 */
public interface StudentMapper {

  Student getStudentById(int id);

  KHInfo getKHInfoById(int id);

}
