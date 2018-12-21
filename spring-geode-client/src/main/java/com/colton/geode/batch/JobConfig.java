package com.colton.geode.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.core.step.item.ChunkOrientedTasklet;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.SyncTaskExecutor;
import sun.security.krb5.internal.SeqNumber;

@Configuration
@EnableBatchProcessing
public class JobConfig {

    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;
    @Bean(name = "test")
    public Job test(){
        return jobBuilderFactory.get("test").start(testStep()).build();

    }

    private Step testStep() {
        return step1();
        //return stepBuilderFactory.get("testStep1.master").partitioner("step1",partitioner()).step(step1()).gridSize(5).taskExecutor(new SimpleAsyncTaskExecutor("Test_")).build();
        //return stepBuilderFactory.get("testStep").chunk(10).faultTolerant().skip(Exception.class).reader(getReader()).writer(getWriter()).taskExecutor(new SyncTaskExecutor()).throttleLimit(5).build();
    }

    private Partitioner partitioner() {
        return  new  UserPartitioner("spring-geode-client/src/it/user.txt");
    }

    private Step step1() {
        return stepBuilderFactory.get("step1").chunk(10).reader(getReader()).writer(getWriter()).taskExecutor(new SimpleAsyncTaskExecutor("st_")).build();

    }




    private ItemWriter getWriter() {
        return new UserWriter();
    }

    private FlatFileItemReader getReader() {
        FlatFileItemReader reader = new UserReader();
        LineMapper lineMapper = new DefaultLineMapper();
        ((DefaultLineMapper) lineMapper).setLineTokenizer(new DelimitedLineTokenizer("|"));
        UserMapper userMapper = new UserMapper();
        ((DefaultLineMapper) lineMapper).setFieldSetMapper(userMapper);
        reader.setLineMapper(lineMapper);
        reader.setResource(new FileSystemResource("spring-geode-client/src/it/user.txt"));
        return reader;
    }
}
