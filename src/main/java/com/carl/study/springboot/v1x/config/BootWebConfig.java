package com.carl.study.springboot.v1x.config;

import com.carl.study.springboot.v1x.config.handlerException.BaseHandlerExceptionResolver;
import com.carl.study.springboot.v1x.config.interceptor.BaseHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @Desc springboot拦截器
 * @Author changez
 * @Time 2018/11/11 14:27
 */
@Configuration
public class BootWebConfig extends WebMvcConfigurerAdapter{

  @Autowired
  private BaseHandlerInterceptor baseHandlerInterceptor;

  @Autowired
  private BaseHandlerExceptionResolver baseHandlerExceptionResolver;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    System.out.println("baseHandlerInterceprot add to configuration");
    registry.addInterceptor(baseHandlerInterceptor).addPathPatterns("/**");
  }

  @Override
  public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
    exceptionResolvers.add(baseHandlerExceptionResolver);
  }
}
