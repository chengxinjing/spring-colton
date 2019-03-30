package batch.jobs;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
//@Import(value = {ReaderConfiguartion.class,WriterConfiguration.class})
public class StepConfiguation {

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean("PRICE_STEP")
    @Scope("prototype")
    @Lazy
    public Step priceStep(@Qualifier("PRICE_READER") FlatFileItemReader reader, @Qualifier("PRICE_WRITER") ItemWriter writer) {
        return stepBuilderFactory.get("PRICE_STEP").chunk(1).reader(reader).writer(writer).build();
    }

}
