package com.colton.spring.geode.entity.imp;

import com.colton.spring.geode.entity.interfaces.Price;
import org.apache.geode.DataSerializer;
import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxWriter;
import org.springframework.data.gemfire.expiration.TimeToLiveExpiration;
import org.springframework.data.gemfire.mapping.annotation.ClientRegion;
import org.springframework.data.gemfire.mapping.annotation.Region;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
@TimeToLiveExpiration(timeout = "6000")
public class PriceEntity implements Price {
    private String key;
    private double cleanPrice;
    private String cusip;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public double getCleanPrice() {
        return cleanPrice;
    }

    public void setCleanPrice(double cleanPrice) {
        this.cleanPrice = cleanPrice;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }


    @Override
    public String toString() {
        return "PriceEntity{" +
                "key='" + key + '\'' +
                ", cleanPrice=" + cleanPrice +
                ", cusip='" + cusip + '\'' +
                '}';
    }

    @Override
    public void toData(PdxWriter writer) {
        writer.writeString("key",this.key);
        writer.writeString("cusip",this.cusip);
        writer.writeDouble("cleanPrice",this.cleanPrice);
    }

    @Override
    public void fromData(PdxReader reader) {
        this.key=reader.readString("key");
        this.cleanPrice=reader.readDouble("cleanPrice");
        this.cusip=reader.readString("cusip");
    }
}
