package com.colton.spring.geode.client.application;

import com.colton.spring.geode.client.application.service.CqMBean;
import com.colton.spring.geode.client.application.service.FunctionClientImp;
import com.colton.spring.geode.client.application.service.PriceService;
import com.colton.spring.geode.entity.imp.PriceEntity;
import com.colton.spring.geode.repository.PriceRepository;
import org.apache.geode.cache.RegionShortcut;
import org.apache.geode.cache.query.FunctionDomainException;
import org.apache.geode.cache.query.NameResolutionException;
import org.apache.geode.cache.query.QueryInvocationTargetException;
import org.apache.geode.cache.query.TypeMismatchException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.gemfire.config.annotation.*;
import org.springframework.data.gemfire.function.config.EnableGemfireFunctionExecutions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ImportResource("client.xml")

@EnableGemfireRepositories(value = "com.colton.spring.geode.repository")
@ComponentScan
@EnableClusterConfiguration(serverRegionShortcut = RegionShortcut.REPLICATE)
@EnableContinuousQueries(poolName = "pool1")
@EnableGemfireFunctionExecutions
public class GeodeClientApplication {
    public static void main(String[] args) throws NameResolutionException, TypeMismatchException, QueryInvocationTargetException, FunctionDomainException {
        //SpringApplication.run(GeodeClientApplication.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GeodeClientApplication.class);
        PriceRepository priceRepository = context.getBean(PriceRepository.class);
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setKey("dd1");
        priceEntity.setCleanPrice(1.1);
        priceEntity.setCusip("cuisp");
        priceRepository.save(priceEntity);

        priceEntity.setKey("dd1");
        priceEntity.setCleanPrice(1.1);
        priceEntity.setCusip("cuisp1");
        priceRepository.save(priceEntity);
        FunctionClientImp functionClientImp = context.getBean(FunctionClientImp.class);
        functionClientImp.getList("最爱你的人是我").stream().forEach(System.out::println);
        //PriceService service = context.getBean(PriceService.class);
        //service.regionName();
    }
}
