package com.colton.geode.batch;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "step")
public class UserReader extends FlatFileItemReader<User> {
    @Value("#{ExecutionContext['startLine']}")
    private int startLine;
    @Override
    protected  User doRead() throws Exception {
        System.err.println(startLine);
        return super.doRead();
    }
}
