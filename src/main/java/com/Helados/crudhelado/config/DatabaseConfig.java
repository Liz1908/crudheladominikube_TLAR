package com.Helados.crudhelado.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

//clase de configuracion para base de datos con Springboot haciendo uso de Bean

@Configuration
public class DatabaseConfig {

    //Primer Bean que contiene toda la info de la conexion para conectarse a la base de datos
    @Bean
    @ConfigurationProperties(prefix = "datasource.myconnection")
    public DataSource crudDataSource (){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate crudJdbcTemplate(DataSource crudDataSource){
        var  jdbcTemplate = new JdbcTemplate(crudDataSource);
        return jdbcTemplate;
    }

    @Bean
    public NamedParameterJdbcTemplate crudNamedParameterJdbcTemplate(JdbcTemplate crudJdbcTemplate){
        return new NamedParameterJdbcTemplate(crudJdbcTemplate);
    }

}
