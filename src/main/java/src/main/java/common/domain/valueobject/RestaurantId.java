package src.main.java.common.domain.valueobject;

import java.util.UUID;

public class RestaurantId extends BaseId<UUID>{

    public RestaurantId(UUID id) {
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
