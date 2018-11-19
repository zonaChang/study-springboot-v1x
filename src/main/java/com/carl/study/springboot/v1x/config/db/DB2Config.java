package com.carl.study.springboot.v1x.config.db;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Desc 数据库2配置
 * @Author changez
 * @Time 2018/11/13 14:07
 */
@Configuration
@MapperScan(basePackages = "com.carl.study.springboot.v1x.mapper.mapperDB2", sqlSessionTemplateRef = "db2SqlSessionTemplate")
public class DB2Config {

  @Bean("db2DataSource")
  @ConfigurationProperties(prefix = "spring.datasource.db2")
  public DataSource setDataSource() {

    return DBConfig.createDataSource();
  }

  @Bean("db2DataSourceTransactionManager")
  public DataSourceTransactionManager setTransactionManager(@Qualifier("db2DataSource") DataSource dataSource) {

    return DBConfig.createTranceManager(dataSource);
  }

  @Bean("db2SqlSessionFactory")
  public SqlSessionFactory setSqlSessionFactory(@Qualifier("db2DataSource") DataSource dataSource) throws Exception {

    return DBConfig.createSqlSessionFactory(dataSource);
  }


  @Bean("db2SqlSessionTemplate")
  public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {

    return DBConfig.createSqlSessionTemplate(sqlSessionFactory);
  }

}
