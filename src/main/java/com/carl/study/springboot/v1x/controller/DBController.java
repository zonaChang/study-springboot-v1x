package com.carl.study.springboot.v1x.controller;

import com.carl.study.springboot.v1x.mapper.mapperDB1.StudentMapper;
import com.carl.study.springboot.v1x.mapper.mapperDB2.KHInfoMapper;
import com.carl.study.springboot.v1x.model.model2.KHInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc 数据库操作类
 * @Author changez
 * @Time 2018/11/13 14:44
 */
@RestController
@RequestMapping("/api/boot/db/")
public class DBController {

  @Autowired
  private StudentMapper studentMapper;

  @Autowired
  private KHInfoMapper khInfoMapper;

  @RequestMapping("db1")
  public Object getObjectByDB1Key(int id){

    return studentMapper.getStudentById(id);
  }
  @RequestMapping("db2")
  public Object getObjectByDB2Key(int id){

    return khInfoMapper.getKHInfoById(id);
  }
}
