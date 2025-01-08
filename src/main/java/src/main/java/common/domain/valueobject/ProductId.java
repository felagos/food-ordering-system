package common.domain.valueobject;

import java.util.UUID;

public class ProductId extends BaseId<UUID> {

    public ProductId(UUID id) {
        super(id);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
