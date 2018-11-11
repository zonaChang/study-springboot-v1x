package com.carl.study.springboot.v1x.service.impl;

import com.carl.study.springboot.v1x.service.ExceptionService;
import org.springframework.stereotype.Service;

/**
 * @Desc service层抛异常
 * @Author changez
 * @Time 2018/11/11 15:06
 */
@Service
public class ExceptionServiceImpl implements ExceptionService{

  @Override
  public String serviceError() {

    System.out.println("into service serviceError");
    String name = null;
    boolean result = name.equals("xx");
    return "serviceError--";
  }
}
