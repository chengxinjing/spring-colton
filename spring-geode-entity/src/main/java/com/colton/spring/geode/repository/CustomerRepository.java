package com.colton.spring.geode.repository;

import com.colton.spring.geode.entity.interfaces.Customer;
import org.springframework.data.gemfire.repository.GemfireRepository;

public interface CustomerRepository extends GemfireRepository<Customer,String> {
}
