/* (C) 2023 */
package com.slalombuild.projectman.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {

  // Define the datasource bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.h2.Driver");
    dataSource.setUrl("jdbc:h2:mem:testdb"); // Change this URL as per your needs
    dataSource.setUsername("username"); // Change username
    dataSource.setPassword("password"); // Change password
    return dataSource;
  }
}
