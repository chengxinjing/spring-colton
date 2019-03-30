package batch.mapper;

import batch.entity.Price;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class PriceItemMapper implements FieldSetMapper<Price> {

    public Price mapFieldSet(FieldSet fieldSet) throws BindException {
        Price price = new Price();
        if (fieldSet.readString(0).equals("quit")) {
            System.err.print("quit");
            throw new BindException("quit", "quit");
        }
        price.setName(fieldSet.readString(0));
        price.setPrice(fieldSet.readInt(1));
        return price;
    }
}
