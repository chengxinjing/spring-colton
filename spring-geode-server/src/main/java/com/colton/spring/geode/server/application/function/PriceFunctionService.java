package com.colton.spring.geode.server.application.function;

import com.colton.spring.geode.entity.interfaces.Price;
import org.apache.geode.cache.configuration.FunctionServiceType;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionAdapter;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.security.ResourcePermission;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class PriceFunctionService implements Function<Price> {

    public boolean hasResult() {
        return false;
    }

    public void execute(FunctionContext<Price> functionContext) {

    }

    public String getId() {
        return "colton";
    }

    public boolean optimizeForWrite() {
        return false;
    }

    public boolean isHA() {
        return false;
    }

    public Collection<ResourcePermission> getRequiredPermissions(String regionName) {
        return null;
    }
}
