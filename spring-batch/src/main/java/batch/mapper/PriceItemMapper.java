package batch.mapper;

import batch.entity.PriceEntity;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class PriceItemMapper implements FieldSetMapper<PriceEntity> {

    public PriceEntity mapFieldSet(FieldSet fieldSet) throws BindException {
        PriceEntity priceEntity = new PriceEntity();
        if (fieldSet.readString(0).equals("quit")) {
            throw new BindException("quit", "quit");
        }
        priceEntity.setName(fieldSet.readString(0));
        priceEntity.setPrice(fieldSet.readInt(1));
        return priceEntity;
    }
}
