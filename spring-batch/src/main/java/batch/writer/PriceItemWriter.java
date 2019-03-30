package batch.writer;

import batch.entity.PriceEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class PriceItemWriter implements ItemWriter<PriceEntity> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PriceItemWriter.class);

    public void write(List<? extends PriceEntity> items) {
        items.stream().forEach(PriceItemWriter::showResult);
    }

    public static void showResult(PriceEntity entity) {
        LOGGER.info("{}", entity);
    }
}
