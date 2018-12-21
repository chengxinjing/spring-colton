package com.colton.geode.client.service;

import com.colton.spring.geode.function.IPriceFunction;
import org.springframework.data.gemfire.function.annotation.FunctionId;
import org.springframework.data.gemfire.function.annotation.OnRegion;

@OnRegion(region = "PRICE")
public interface PriceFunction extends IPriceFunction {

    @FunctionId(value = "testPrice")
    void testPriceFunction(String str);
}
