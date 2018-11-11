package com.carl.study.springboot.v1x.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Desc 集中日志处理类
 * @Author changez
 * @Time 2018/11/11 15:24
 */
@Aspect
@Component
@Slf4j
public class LogAop {

  @Pointcut("execution(* com.carl.study.springboot.v1x.controller..*.*(..)) || execution(* com.carl.study.springboot.v1x.config.handlerException.BaseHandlerExceptionResolver.*(..))")
  private void pointCut(){}

  @Around("pointCut()")
  public Object aroundRecodeLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

    Object invokeResult = proceedingJoinPoint.proceed();

    if (invokeResult instanceof ModelAndView) {
      log.error("log occur exception");
    } else {
      log.info("log normal..");
    }

    return invokeResult;
  }
}
