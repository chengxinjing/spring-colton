package com.colton.spring.geode.client.application.service;

import com.colton.spring.geode.entity.imp.PriceEntity;
import com.colton.spring.geode.entity.interfaces.Customer;
import com.colton.spring.geode.entity.interfaces.Price;
import org.apache.geode.cache.query.CqEvent;
import org.apache.geode.cache.query.CqException;
import org.apache.geode.cache.query.CqQuery;
import org.apache.geode.cache.query.RegionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.gemfire.listener.annotation.ContinuousQuery;
import org.springframework.stereotype.Component;

@Component
public class CqMBean {

    @Autowired
    PriceService priceService;
    @ContinuousQuery(name="priceCq",query = "SELECT * FROM /PRICE_CACHE where key = 'dd1'")
   public void handleCq(Object event,Object n) throws CqException, RegionNotFoundException {
      /*  CqQuery cqQuery = event.getCq();
        if (cqQuery.isRunning()){
            cqQuery.stop();
            cqQuery.executeWithInitialResults().iterator().forEachRemaining(System.out::println);
        }
        System.out.println(event.getCq());
        if (!event.getCq().isRunning()){
            try {
                cqQuery.executeWithInitialResults().iterator().forEachRemaining(System.out::println);
            } catch (RegionNotFoundException e) {
                e.printStackTrace();
            } catch (CqException e) {
                e.printStackTrace();
            }
        }*/
      if (n instanceof Price){
          System.out.println(n);
        //  priceService.save((Price)n);
      }

    }

}
