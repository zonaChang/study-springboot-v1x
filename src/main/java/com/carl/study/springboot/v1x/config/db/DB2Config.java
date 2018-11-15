package com.carl.study.springboot.v1x.config.db;

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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
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
  public DataSource setDataSource(){

    return DataSourceBuilder.create().build();
  }

  @Bean("db2DataSourceTransactionManager")
  public DataSourceTransactionManager setTransactionManager(@Qualifier("db2DataSource") DataSource dataSource){

    return new DataSourceTransactionManager(dataSource);
  }

  @Bean("db2SqlSessionFactory")
  public SqlSessionFactory setSqlSessionFactory(@Qualifier("db2DataSource") DataSource dataSource) throws Exception {

    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);

    //设置mapper.xml文件位置， 如果mapper.xml和mapper接口的名字和路径完全一致，可以省略该配置
    //idea应其自身特性， 对src/main/java下的内容编译时，会自动忽略xml文件， 所以需要在pom中配置resources的filter，详见pom文件
//    bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com\\carl\\study\\springboot\\v1x\\mapper\\mapperDB2\\*.xml"));

    // 配置bean的别名
    bean.setTypeAliasesPackage("com.carl.study.springboot.v1x.model.model2");

    return bean.getObject();
  }


  @Bean("db2SqlSessionTemplate")
  public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSessionFactory){

    return new SqlSessionTemplate(sqlSessionFactory);
  }

}
