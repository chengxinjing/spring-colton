package com.colton.geode.client.service;

import org.apache.geode.cache.query.CqEvent;
import org.springframework.data.gemfire.listener.annotation.ContinuousQuery;
import org.springframework.stereotype.Component;

@Component
public class PriceCq {

    @ContinuousQuery(name = "priceCqq",query = "select * from /PRICE where key=pacman")
    public void handle(CqEvent cqEvent){
        System.err.println("price cq execution");
    }
}
