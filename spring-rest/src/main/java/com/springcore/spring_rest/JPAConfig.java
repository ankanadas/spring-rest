package com.springcore.spring_rest;



import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value="classpath:application.properties")
public class JPAConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean emf(){
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setDataSource(getDataSource());
		emf.setJpaProperties(jpaProperties());
		emf.setPackagesToScan("com.springcore.spring_rest.entity");
		return emf;
	}
	
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl(env.getProperty("db.url","jdbc:mysql://localhost:3306/example"));
		ds.setUsername(env.getProperty("db.username","kkk"));
		ds.setPassword(env.getProperty("db.password","hjh"));
		
		return ds;
	}
	@Bean
	public PlatformTransactionManager txMgr(EntityManagerFactory emf){
		return new JpaTransactionManager(emf);
	}
	private Properties jpaProperties(){
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.dml"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show"));
		props.setProperty("hibernate.format_sql", env.getProperty("hibernate.form"));
		return props;
	}
}
