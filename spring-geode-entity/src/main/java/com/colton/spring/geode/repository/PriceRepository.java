package com.colton.spring.geode.repository;

import com.colton.spring.geode.entity.interfaces.Price;
import org.apache.geode.cache.Region;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.gemfire.repository.GemfireRepository;
public interface PriceRepository extends GemfireRepository<Price,String> {
}
