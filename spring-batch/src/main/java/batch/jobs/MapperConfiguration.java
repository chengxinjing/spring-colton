package batch.jobs;

import batch.mapper.PriceItemMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class MapperConfiguration {

    @Bean("PRICE_MAPPER")
    @Lazy
    public PriceItemMapper priceItemMapper() {
        return new PriceItemMapper();
    }
}
