package com.colton.spring.geode.server.application.function;

import com.colton.spring.geode.entity.interfaces.IFunction;
import org.springframework.data.gemfire.function.annotation.GemfireFunction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class FunctionServImp implements IFunction {

    @Override
    @GemfireFunction(id = "serverFunction")
    public void doIt(String str) {
        System.out.print("server function"+ str);
    }

    @GemfireFunction(id = "getList",hasResult = true)
    public List<String> getList(String str){
        List<String> stringList = new ArrayList<>();
        stringList.add(str);
        return stringList;
    }
}
