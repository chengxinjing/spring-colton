package batch.writer;

import batch.entity.Price;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class PriceitemWriter implements ItemWriter<Price> {
    public void write(List<? extends Price> items) {
        items.stream().forEach(item -> {
            System.out.println(item);
        });
    }
}
