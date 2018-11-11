package com.carl.study.springboot.v1x.config.handlerException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc 基础全局异常处理
 * @Author changez
 * @Time 2018/11/11 14:52
 */
@Component
public class BaseHandlerExceptionResolver implements HandlerExceptionResolver{

  @Override
  public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    System.out.println("occur exception, into baseHandlerExceptionResolver");
    e.printStackTrace();

    Map<String, Object> errMap = new HashMap<>();
    errMap.put("errNo", -1);
    errMap.put("errInfo", e.getMessage());
    ModelAndView mv = new ModelAndView(new MappingJackson2JsonView()).addAllObjects(errMap);
    return mv;
  }
}
