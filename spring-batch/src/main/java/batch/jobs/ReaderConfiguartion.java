package batch.jobs;

import batch.entity.PriceEntity;
import batch.mapper.PriceItemMapper;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.FileSystemResource;

@Configuration
//@Import(value = MapperConfiguration.class)
public class ReaderConfiguartion {
    @Autowired
    private InputFile inputFile;

    @Bean("PRICE_READER")
    @Scope("prototype")
    @Lazy
    public FlatFileItemReader<PriceEntity> priceReader(@Qualifier("PRICE_MAPPER") PriceItemMapper priceItemMapper) {
        FlatFileItemReader<PriceEntity> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource(inputFile.getInputFileName()));
        DefaultLineMapper mapper = new DefaultLineMapper();
        mapper.setFieldSetMapper(priceItemMapper);
        mapper.setLineTokenizer(new DelimitedLineTokenizer("|"));
        reader.setLineMapper(mapper);

        return reader;
    }
}
