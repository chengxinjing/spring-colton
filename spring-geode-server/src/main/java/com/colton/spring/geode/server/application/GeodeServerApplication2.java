package com.colton.spring.geode.server.application;

import org.apache.geode.cache.RegionShortcut;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnablePdx;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@CacheServerApplication(name = "server3",locators = "localhost[31431]",port =9091 )
//@ComponentScan
@EnablePdx
public class GeodeServerApplication2 {
    public static void main(String[] args){
        SpringApplication.run(GeodeServerApplication2.class);
    }
}
