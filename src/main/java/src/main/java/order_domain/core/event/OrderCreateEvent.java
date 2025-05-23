package src.main.java.order_domain.core.event;

import java.time.ZonedDateTime;

import src.main.java.order_domain.core.entity.Order;

public class OrderCreateEvent extends OrderEvent {

    public OrderCreateEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }

}
