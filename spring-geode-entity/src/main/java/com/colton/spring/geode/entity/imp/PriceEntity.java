package com.colton.spring.geode.entity.imp;

import com.colton.spring.geode.entity.interfaces.Price;
import org.apache.geode.DataSerializer;
import org.springframework.data.gemfire.expiration.TimeToLiveExpiration;
import org.springframework.data.gemfire.mapping.annotation.ClientRegion;
import org.springframework.data.gemfire.mapping.annotation.Region;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
@Region("PRICE_CACHE")
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

    public void toData(DataOutput dataOutput) throws IOException {
        DataSerializer.writeString(key, dataOutput);
        DataSerializer.writeString(cusip, dataOutput);
        DataSerializer.writeDouble(cleanPrice, dataOutput);
    }

    public void fromData(DataInput dataInput) throws IOException, ClassNotFoundException {
        this.key = DataSerializer.readString(dataInput);
        this.cusip = DataSerializer.readString(dataInput);
        this.cleanPrice = DataSerializer.readDouble(dataInput);
    }

    @Override
    public String toString() {
        return "PriceEntity{" +
                "key='" + key + '\'' +
                ", cleanPrice=" + cleanPrice +
                ", cusip='" + cusip + '\'' +
                '}';
    }
}
