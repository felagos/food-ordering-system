package src.main.java.order_domain.core.event;

import src.main.java.order_domain.core.entity.Order;
import java.time.ZonedDateTime;

public class OrderPaidEvent extends OrderEvent {

    public OrderPaidEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }

}
