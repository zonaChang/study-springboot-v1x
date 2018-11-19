package com.carl.study.springboot.v1x.config.db;

import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Desc 多数据源相同配置操作
 * @Author changez
 * @Time 2018/11/16 9:30
 */
public final class DBConfig {

  /**
   * @Desc: 创建数据源DataSource实例
   * @Auth: changez
   * @Time: 2018/11/16 9:35
   * @param 
   * @return: javax.sql.DataSource
   */
  public static DataSource createDataSource(){

    return DataSourceBuilder.create().build();
  }

  /**
   * @Desc: 创建数据源事务管理器
   * @Auth: changez
   * @Time: 2018/11/16 9:51
   * @param dataSource
   * @return: org.springframework.jdbc.datasource.DataSourceTransactionManager
   */
  public static DataSourceTransactionManager createTranceManager(DataSource dataSource){

    return new DataSourceTransactionManager(dataSource);
  }

  /**
   * @Desc: 创建sessionben实例
   * @Auth: changez
   * @Time: 2018/11/16 9:49
   * @param dataSource
   * @return: org.mybatis.spring.SqlSessionFactoryBean
   */
  public static SqlSessionFactory createSqlSessionFactory(DataSource dataSource) throws Exception {

    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);

    //设置mapper.xml文件位置， 如果mapper.xml和mapper接口的名字和路径完全一致，可以省略该配置.
    //idea应其自身特性， 对src/main/java下的内容编译时，会自动忽略xml文件， 所以需要在pom中配置resources的filter，详见pom文件
//    bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com\\carl\\study\\springboot\\v1x\\mapper\\mapperDB2\\*.xml"));

    // 配置bean的别名, 如果用到其他数据源的model， 则也需要将其配置在这里
    bean.setTypeAliasesPackage("com.carl.study.springboot.v1x.model.model1,com.carl.study.springboot.v1x.model.model2,com.carl.study.springboot.v1x.model.model3");

    //解决java -jar xxx.jar运行时，找不到bean的别名问题
    VFS.addImplClass(SpringBootVFS.class);
//    bean.setVfs(SpringBootVFS.class);

    return bean.getObject();
  }

  /**
   * @Desc: 创建SQLSessionTemplate实例
   * @Auth: changez
   * @Time: 2018/11/16 10:00
   * @param sqlSessionFactory
   * @return: org.mybatis.spring.SqlSessionTemplate
   */
  public static SqlSessionTemplate createSqlSessionTemplate(SqlSessionFactory sqlSessionFactory){

    return new SqlSessionTemplate(sqlSessionFactory);
  }

}
