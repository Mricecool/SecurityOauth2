package com.jconfig.config;


import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Properties;

/**
 * 数据源配置
 * Created by mr on 2017/8/22.
 */
@Configuration
public class DataSourceConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean lc=new LocalContainerEntityManagerFactoryBean();
        lc.setPersistenceUnitName("defaultPersistenceUnit");
        lc.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        lc.setPackagesToScan("com.jconfig");
        lc.setJpaVendorAdapter(hibernateJpaVendorAdapter());
        lc.setJpaProperties(getProperties());
        return lc;
    }

    @Bean
    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter(){
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter=new HibernateJpaVendorAdapter();
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }


    public Properties getProperties(){
        Properties properties=new Properties();
        properties.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
        properties.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/authority?useSSL=false");
        properties.setProperty("hibernate.connection.username","root");
        properties.setProperty("hibernate.connection.password","root");
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.connection.useUnicode","true");
        properties.setProperty("hibernate.connection.characterEncoding","UTF-8");
        properties.setProperty("hibernate.format_sql","true");
        properties.setProperty("hibernate.use_sql_comments","true");
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        properties.setProperty("hibernate.connection.autoReconnect","true");
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("connection.autoReconnectForPools","true");
        properties.setProperty("connection.is-connection-validation-required","true");

        properties.setProperty("hibernate.c3p0.validate","true");
        properties.setProperty("hibernate.connection.provider_class","org.hibernate.service.jdbc.connections.internal.C3P0ConnectionProvider");
        properties.setProperty("hibernate.c3p0.min_size","5");
        properties.setProperty("hibernate.c3p0.max_size","600");
        properties.setProperty("hibernate.c3p0.timeout","1800");
        properties.setProperty("hibernate.c3p0.max_statements","50");
        properties.setProperty("hibernate.c3p0.preferredTestQuery","SELECT 1;");
        properties.setProperty("hibernate.c3p0.testConnectionOnCheckout","true");
        properties.setProperty("hibernate.c3p0.idle_test_period","3000");

        return properties;
    }

}
