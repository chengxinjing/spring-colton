package com.colton.spring.geode.server.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.gemfire.config.annotation.*;
import org.springframework.data.gemfire.function.config.EnableGemfireFunctions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@CacheServerApplication(name="server",locators = "localhost[31431]")
//@EnableLocator
@EnableManager
@ImportResource("server.xml")
@ComponentScan
@EnablePdx
@EnableExpiration
@EnableGemfireFunctions()
public class GeodeServerApplication {
    public static void main(String[] args){
        SpringApplication.run(GeodeServerApplication.class);
    }
}
