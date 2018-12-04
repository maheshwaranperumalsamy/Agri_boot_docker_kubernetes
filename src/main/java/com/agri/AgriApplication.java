package com.agri;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.agri"})
@SpringBootApplication
public class AgriApplication {

    @Value("${datasource.url}")
    private String url;
    @Value("${datasource.username}")
    private String username;
    @Value("${datasource.password}")
    private String password;
    @Value("${datasource.driver-class-name}")
    private String driver;

    public static void main(final String[] args) {
        SpringApplication.run(AgriApplication.class, args);
    }

    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
            .url(url)
            .driverClassName(driver)
            .username(username)
            .password(password)
            .build();
    }
}

