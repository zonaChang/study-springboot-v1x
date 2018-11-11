package com.carl.study.springboot.v1x.controller;

import com.carl.study.springboot.v1x.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc 异常处理类
 * @Author changez
 * @Time 2018/11/11 14:58
 */
@RestController
@RequestMapping("/api/boot/exception/")
public class ExceptionController {

  @Autowired
  private ExceptionService exceptionService;

  @RequestMapping("controller/error")
  public String controllerError(){

    System.out.println("into controllerError");
    int a = 3/0;
    return "controllerError";
  }

  @RequestMapping("service/error")
  public String serviceError(){

    System.out.println("into serviceError");

    return exceptionService.serviceError();
  }

}
