package test;

import com.colton.geode.client.xmlClient.XmlClient;
import com.colton.geode.client.service.PriceFunction;
import com.colton.spring.geode.entity.imp.PriceEntity;
import com.colton.spring.geode.entity.interfaces.Price;
import com.colton.spring.geode.repository.PriceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = XmlClient.class)
public class AllTest {

    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private PriceFunction priceFunction;
    @Test
    public void testForSave(){
        for(int  i = 0; i<10 ;i++){
            Price price = new PriceEntity();
            price.setKey(String.valueOf(i));
            price.setCleanPrice(i);
            price.setCusip(String.valueOf(i+1));
            priceRepository.save(price);
        }
    }

    @Test
    public void testForCq(){
        Price price = new PriceEntity();
        price.setKey("pacman");
        price.setCleanPrice(1.2);
        price.setCusip("131");
        priceRepository.save(price);

    }
    @Test
    public void testForFunction(){
        priceFunction.testPriceFunction("price function test");
    }
}
