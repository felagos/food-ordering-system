package src.main.java.order_domain.core.event;

import java.time.ZonedDateTime;

import src.main.java.common.domain.events.DomainEvent;
import src.main.java.order_domain.core.entity.Order;

public abstract class OrderEvent implements DomainEvent<Order> {

    private final Order order;
    private final ZonedDateTime createdAt;

    public OrderEvent(Order order, ZonedDateTime createdAt) {
        this.order = order;
        this.createdAt = createdAt;
    }

    public Order getOrder() {
        return order;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
