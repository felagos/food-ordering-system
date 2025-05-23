package src.main.java.order_domain.core.event;

import java.time.ZonedDateTime;
import src.main.java.order_domain.core.entity.Order;

public class OrderCancelEvent extends OrderEvent {

    public OrderCancelEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }

}