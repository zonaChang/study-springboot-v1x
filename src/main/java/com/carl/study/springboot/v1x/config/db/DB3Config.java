package com.carl.study.springboot.v1x.config.db;

import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Desc 数据库3配置
 * @Author changez
 * @Time 2018/11/13 14:07
 */
@Configuration
@MapperScan(basePackages = "com.carl.study.springboot.v1x.mapper.mapperDB3", sqlSessionTemplateRef = "db3SqlSessionTemplate")
public class DB3Config {

  @Bean("db3DataSource")
  @ConfigurationProperties(prefix = "spring.datasource.db3")
  public DataSource setDataSource(){

    return DBConfig.createDataSource();
  }

  @Bean("db3DataSourceTransactionManager")
  public DataSourceTransactionManager setTransactionManager(@Qualifier("db3DataSource") DataSource dataSource){

    return DBConfig.createTranceManager(dataSource);
  }

  @Bean("db3SqlSessionFactory")
  public SqlSessionFactory setSqlSessionFactory(@Qualifier("db3DataSource") DataSource dataSource) throws Exception {

    return DBConfig.createSqlSessionFactory(dataSource);
  }


  @Bean("db3SqlSessionTemplate")
  public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("db3SqlSessionFactory") SqlSessionFactory sqlSessionFactory){

    return DBConfig.createSqlSessionTemplate(sqlSessionFactory);
  }

}
