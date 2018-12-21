package com.colton.geode.client.service;

import com.colton.spring.geode.entity.interfaces.Price;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.util.CacheListenerAdapter;
import org.springframework.stereotype.Component;

@Component
public class PriceCacheListener extends CacheListenerAdapter<String,Price> {
    @Override
    public void afterUpdate(EntryEvent<String, Price> event) {
       System.err.println(event.getKey());
    }
}
