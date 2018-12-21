package com.colton.geode.server.xmlServer;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;
import org.springframework.data.gemfire.config.annotation.EnablePdx;
@CacheServerApplication(name = "xmlServer",locators = "localhost[31431]",port = 9090)
@ImportResource(value = "server.xml")
@EnablePdx
@ComponentScan(basePackages = "com.colton.geode.client.service")
public class XmlServer {
    public static void main(String[] args){
        SpringApplication.run(XmlServer.class);
    }
}
