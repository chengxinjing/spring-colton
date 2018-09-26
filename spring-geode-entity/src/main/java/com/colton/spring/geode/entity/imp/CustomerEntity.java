package com.colton.spring.geode.entity.imp;

import com.colton.spring.geode.entity.interfaces.Customer;
import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializer;
import org.apache.geode.pdx.PdxWriter;
import org.springframework.data.gemfire.mapping.annotation.Region;

@Region("CUSTOMER_CACHE")
public class CustomerEntity implements Customer {
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String key;
    private String name;

    public void toData(PdxWriter pdxWriter) {
        pdxWriter.writeString("key",key);
        pdxWriter.writeString("name",name);
    }

    public void fromData(PdxReader pdxReader) {
       this.name=  pdxReader.readString("name");
       this.key=pdxReader.readString(key);
    }
}
