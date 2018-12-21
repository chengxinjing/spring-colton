package com.colton.geode.batch;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class UserWriter implements ItemWriter<User> {
    @Override
    public synchronized   void write(List<? extends User> items) throws Exception {
        System.err.println("=========="+items.size());
      items.stream().forEach(System.out::println);
        System.err.println(Thread.currentThread().getName());
    }
}
