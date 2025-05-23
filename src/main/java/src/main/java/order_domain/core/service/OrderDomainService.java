package src.main.java.order_domain.core.service;

import java.util.List;

import src.main.java.order_domain.core.entity.Order;
import src.main.java.order_domain.core.entity.Restaurant;
import src.main.java.order_domain.core.event.OrderCancelEvent;
import src.main.java.order_domain.core.event.OrderCreateEvent;
import src.main.java.order_domain.core.event.OrderPaidEvent;

public interface OrderDomainService {

    OrderCreateEvent validateAndInitiateOrder(Order order, Restaurant restaurant);

    OrderPaidEvent payOrder(Order order);

    void approveOrder(Order order);

    OrderCancelEvent cancelOrderPayment(Order order, List<String> failureMessages);

    void cancelOrder(Order order, List<String> failureMessages);

}
