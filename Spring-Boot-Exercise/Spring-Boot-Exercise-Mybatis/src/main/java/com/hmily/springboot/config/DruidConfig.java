package com.hmily.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by zyzhmily on 2019/3/19.
 */
@Configuration
@PropertySources(value = {@PropertySource("classpath:db.properties")})
public class DruidConfig {

    @Autowired
    private Environment environment;

    @Bean(name = "dataSource", destroyMethod = "close", initMethod = "init")
    public DruidDataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(environment.getRequiredProperty("dataSource.url"));
        datasource.setUsername(environment.getRequiredProperty("dataSource.username"));
        datasource.setPassword(environment.getRequiredProperty("dataSource.password"));
        datasource.setDriverClassName(environment.getRequiredProperty("dataSource.driverClassName"));

        datasource.setInitialSize(Integer.parseInt(environment.getRequiredProperty("dataSource.initialSize")));
        datasource.setMinIdle(Integer.parseInt(environment.getRequiredProperty("dataSource.minIdle")));
        datasource.setMaxActive(Integer.parseInt(environment.getRequiredProperty("dataSource.maxActive")));
        datasource.setMaxWait(Long.parseLong(environment.getRequiredProperty("dataSource.maxWait")));
        datasource.setTimeBetweenEvictionRunsMillis(Long.parseLong(environment.getRequiredProperty("dataSource.timeBetweenEvictionRunsMillis")));
        datasource.setMinEvictableIdleTimeMillis(Long.parseLong(environment.getRequiredProperty("dataSource.minEvictableIdleTimeMillis")));

        datasource.setValidationQuery(environment.getRequiredProperty("dataSource.validationQuery"));
        datasource.setTestWhileIdle(Boolean.parseBoolean(environment.getRequiredProperty("dataSource.testWhileIdle")));
        datasource.setTestOnBorrow(Boolean.parseBoolean(environment.getRequiredProperty("dataSource.testOnBorrow")));
        datasource.setTestOnReturn(Boolean.parseBoolean(environment.getRequiredProperty("dataSource.testOnReturn")));

        datasource.setPoolPreparedStatements(Boolean.parseBoolean(environment.getRequiredProperty("dataSource.poolPreparedStatements")));
        datasource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(environment.getRequiredProperty("dataSource.maxPoolPreparedStatementPerConnectionSize")));
        datasource.setUseGlobalDataSourceStat(Boolean.parseBoolean(environment.getRequiredProperty("dataSource.useGlobalDataSourceStat")));
        try {
            datasource.setFilters(environment.getRequiredProperty("dataSource.filters"));
        } catch (SQLException e) {
            System.err.println("druid configuration initialization filter: "+ e);
        }
        datasource.setConnectionProperties(environment.getRequiredProperty("dataSource.connectionProperties"));
        return datasource;
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        //配置参数参考ResourceServlet类
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");
        // 默认就是允许所有访问
        initParams.put("allow", "");
        // 决绝访问
        initParams.put("deny", "");
        bean.setInitParameters(initParams);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
