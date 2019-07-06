package com.boostrdev.weblogic.legacy;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.WebApplicationInitializer;

@EnableAutoConfiguration(exclude = {JpaRepositoriesAutoConfiguration.class })
//@EnableAutoConfiguration
//@EnableJpaRepositories("com.boostrdev.weblogic.legacy.dao.*")
//@EnableJpaRepositories
@Configuration
@ComponentScan

public class SpringBootWebLogicLegacyApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebLogicLegacyApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootWebLogicLegacyApplication.class).showBanner(false);
	}
	
	 @Bean
	    public DataSource dataSource(){
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	        dataSource.setUrl("jdbc:oracle:thin:@10.31.11.21:1521:VIS");
	        dataSource.setUsername("CITICNT");
	        dataSource.setPassword("CITICNT");
	        return dataSource;
	    }
	 
	 @Bean
	 public JdbcTemplate jdbcTemplate() {
	     return new JdbcTemplate(dataSource());
	 }
}
