package com.colton.geode.client.service;

import com.colton.spring.geode.entity.interfaces.Price;
import org.apache.geode.cache.CacheWriterException;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.util.CacheWriterAdapter;
import org.springframework.stereotype.Component;

@Component
public class PriceCacheWriter extends CacheWriterAdapter<String,Price> {
    @Override
    public void beforeUpdate(EntryEvent<String, Price> event) throws CacheWriterException {
        System.err.println(event.getKey()+"++++++++++++++cache writer");
    }
}
