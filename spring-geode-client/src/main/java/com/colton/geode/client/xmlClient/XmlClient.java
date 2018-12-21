package com.colton.geode.client.xmlClient;

import com.colton.geode.client.service.PriceCq;
import com.colton.geode.client.service.PriceFunction;
import com.colton.spring.geode.entity.imp.PriceEntity;
import com.colton.spring.geode.entity.interfaces.Price;
import com.colton.spring.geode.repository.PriceRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.gemfire.config.annotation.EnableContinuousQueries;
import org.springframework.data.gemfire.config.annotation.EnablePdx;
import org.springframework.data.gemfire.function.config.EnableGemfireFunctionExecutions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@ImportResource(locations = "client.xml")
@EnableGemfireRepositories(basePackageClasses =PriceRepository.class )
@EnableGemfireFunctionExecutions(basePackageClasses = PriceFunction.class)
@EnablePdx
@EnableContinuousQueries
@ComponentScan(basePackages = "com.colton.geode.client.service")
public class XmlClient {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(XmlClient.class);
     PriceRepository repository = context.getBean(PriceRepository.class);
      Thread.sleep(200);
     context.getBean(PriceCq.class);
     Price price = new PriceEntity();
     price.setKey("pacman");
     price.setCleanPrice(1.1);
     repository.save(price);

    }
}
