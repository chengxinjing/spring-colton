package com.colton.geode.client.service;

import com.colton.spring.geode.function.IPriceFunction;
import org.springframework.data.gemfire.function.annotation.GemfireFunction;
import org.springframework.data.gemfire.function.config.EnableGemfireFunctions;
import org.springframework.stereotype.Component;

@Component
@EnableGemfireFunctions
public class PriceFunctionImp implements IPriceFunction {
    @Override
    @GemfireFunction(id = "testPrice")
    public void testPriceFunction(String str) {
        System.err.println(str);
    }
}
