package src.main.java.order_domain.core.valueobject;

import src.main.java.common.domain.valueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {

    public TrackingId(UUID id) {
        super(id);
    }

}
