package com.cristian.formMySql.connection;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conexion {
	public DriverManagerDataSource conectar()
    {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring");
        dataSource.setUsername("root");
        dataSource.setPassword("28Cristian30");
        return dataSource;
    }
}
