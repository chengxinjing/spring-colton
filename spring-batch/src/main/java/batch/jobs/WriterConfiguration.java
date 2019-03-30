package batch.jobs;

import batch.writer.PriceitemWriter;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class WriterConfiguration {
    @Bean("PRICE_WRITER")
    @Lazy
    public ItemWriter priceWriter() {
        return new PriceitemWriter();
    }
}
