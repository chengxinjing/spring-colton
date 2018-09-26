package com.colton.spring.geode.server.application.listener;

import org.apache.geode.cache.CacheListener;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.RegionEvent;
import org.apache.geode.cache.util.CacheListenerAdapter;
import org.springframework.stereotype.Component;

@Component("priceCacheListener")
public class PriceCacheListener extends CacheListenerAdapter {
    @Override
    public void afterCreate(EntryEvent event) {
        super.afterCreate(event);
        System.out.println("PRICE_CACHE created ++++");
    }

    @Override
    public void afterUpdate(EntryEvent event) {
        super.afterUpdate(event);
        System.out.println("region update");
    }

    @Override
    public void afterRegionClear(RegionEvent event) {
        super.afterRegionClear(event);
        System.out.println(event.getRegion()+"be cleared ++++++++++++");
    }
}
