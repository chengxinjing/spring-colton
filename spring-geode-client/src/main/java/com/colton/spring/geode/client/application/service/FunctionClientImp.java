package com.colton.spring.geode.client.application.service;

import com.colton.spring.geode.entity.interfaces.IFunction;
import org.springframework.data.gemfire.function.annotation.FunctionId;
import org.springframework.data.gemfire.function.annotation.OnServer;

import java.util.List;

@OnServer(cache ="clientCache",pool ="pool1" )
public interface FunctionClientImp extends IFunction {

    @FunctionId(value = "serverFunction")
     void doMe(String str);
    @FunctionId(value = "getList")
    List<String> getList(String str);
}
