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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Desc 数据库1配置
 * @Author changez
 * @Time 2018/11/13 13:30
 */
@Configuration
@MapperScan(basePackages = "com.carl.study.springboot.v1x.mapper.mapperDB1", sqlSessionTemplateRef = "db1SqlSessionTemplate")
public class DB1Config {

  @Bean("db1DataSource")
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource.db1")
  public DataSource setDataSource() {

    return DataSourceBuilder.create().build();
  }

  @Bean(name = "db1TransactionManager")
  @Primary
  public DataSourceTransactionManager setTransactionManager(@Qualifier("db1DataSource") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean("db1SqlSessionFactory")
  @Primary
  public SqlSessionFactory setSqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception {

    SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
    sessionFactoryBean.setDataSource(dataSource);
    //设置mapper.xml文件位置， 如果mapper.xml和mapper接口的名字和路径完全一致，可以省略该配置
    //idea应其自身特性， 对src/main/java下的内容编译时，会自动忽略xml文件， 所以需要在pom中配置resources的filter，详见pom文件
//    sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com\\carl\\study\\springboot\\v1x\\mapper\\mapperDB1\\*.xml"));


    //解决java -jar xxx.jar运行时，找不到bean的别名问题
    VFS.addImplClass(SpringBootVFS.class);

    // 配置bean的别名, 如果用到其他数据源的model， 则也需要将其配置在这里
    sessionFactoryBean.setTypeAliasesPackage("com.carl.study.springboot.v1x.model.model1,com.carl.study.springboot.v1x.model.model2");

    return sessionFactoryBean.getObject();

  }

  @Bean("db1SqlSessionTemplate")
  @Primary
  public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory){

    return new SqlSessionTemplate(sqlSessionFactory);
  }
}