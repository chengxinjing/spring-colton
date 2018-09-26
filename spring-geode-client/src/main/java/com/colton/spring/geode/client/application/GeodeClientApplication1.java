package com.colton.spring.geode.client.application;

import com.colton.spring.geode.entity.imp.CustomerEntity;
import com.colton.spring.geode.entity.interfaces.Customer;
import com.colton.spring.geode.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnablePdx;
import org.springframework.data.gemfire.config.annotation.EnablePool;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import java.util.Collections;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ClientCacheApplication
@EnableGemfireRepositories(value = "com.colton.spring.geode.repository")
@EnableEntityDefinedRegions(value = "com.colton.spring.geode.entity.imp")
@EnablePool(name = "pool2")
@Profile(value = "gemfire")
@EnablePdx
public class GeodeClientApplication1 {
    public static void main(String[] args){
        //SpringApplication.run(GeodeClientApplication1.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GeodeClientApplication1.class);
        CustomerRepository repository = context.getBean(CustomerRepository.class);
        repository.deleteAll();
        Customer customer = new CustomerEntity();
        customer.setKey("cheng1");
        customer.setName("wangda");

        repository.save(customer);
        repository.findAll().forEach(item->{System.out.println(item.getName());});
    }
}
