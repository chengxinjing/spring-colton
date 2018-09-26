package com.colton.spring.geode.entity.interfaces;

import org.apache.geode.DataSerializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Indexed;
import org.springframework.data.gemfire.mapping.annotation.Region;

@Region("/PRICE_CACHE")
public interface Price extends DataSerializable {
    @Id
    String getKey();

    void setKey(String key);

    @Indexed(name = "cusipIdx")
    String getCusip();

    void setCusip(String cusip);

    double getCleanPrice();

    void setCleanPrice(double cleanPrice);
}
