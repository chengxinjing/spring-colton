package com.colton.spring.geode.entity.interfaces;

import org.apache.geode.pdx.PdxSerializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

@Region("/CUSTOMER_CACHE")
public interface Customer extends PdxSerializable {
    @Id
    String getKey();

    String getName();

    void setKey(String key);

    void setName(String name);
}
