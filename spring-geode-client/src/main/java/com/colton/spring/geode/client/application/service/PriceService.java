package com.colton.spring.geode.client.application.service;

import com.colton.spring.geode.entity.interfaces.Price;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.query.FunctionDomainException;
import org.apache.geode.cache.query.NameResolutionException;
import org.apache.geode.cache.query.QueryInvocationTargetException;
import org.apache.geode.cache.query.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.gemfire.config.annotation.EnablePool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@DependsOn("clientCache")
public class PriceService {

    @Resource(name = "PRICE_CACHE")
    Region region;

    public void regionName() throws NameResolutionException, TypeMismatchException, QueryInvocationTargetException, FunctionDomainException {
      System.out.println(region.query("select * from /PRICE_CACHE"));
      region.clear();
    }

    public void save(Price n) {
        region.put(n.getKey(),n);
    }
}
