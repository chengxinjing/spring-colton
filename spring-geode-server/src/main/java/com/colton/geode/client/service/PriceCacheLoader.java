package com.colton.geode.client.service;

import com.colton.spring.geode.entity.interfaces.Price;
import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.LoaderHelper;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class PriceCacheLoader implements CacheLoader<String,Price> {

    private  static Map<String,Double> map =  new ConcurrentHashMap<>();
    @Override
    public Price load(LoaderHelper<String, Price> helper) throws CacheLoaderException {
        String key = helper.getKey();
        Price price = null;
       if (map.containsKey(key)){
           price.setKey(key);
           price.setCleanPrice(map.get(key));
           price.setCusip(key);
       }
        return price;
    }
    static {
        map.put("colton",1.1);
        map.put("pacman",1.2);
    }
}
