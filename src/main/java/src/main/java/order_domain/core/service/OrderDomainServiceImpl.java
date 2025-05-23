package src.main.java.order_domain.core.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import src.main.java.common.domain.valueobject.ProductId;
import src.main.java.order_domain.core.entity.Order;
import src.main.java.order_domain.core.entity.Product;
import src.main.java.order_domain.core.entity.Restaurant;
import src.main.java.order_domain.core.event.OrderCancelEvent;
import src.main.java.order_domain.core.event.OrderCreateEvent;
import src.main.java.order_domain.core.event.OrderPaidEvent;
import src.main.java.order_domain.core.exception.OrderDomainException;

@Slf4j
public class OrderDomainServiceImpl implements OrderDomainService {

    private static final String UTC_ZONE = "UTC";

    @Override
    public OrderCreateEvent validateAndInitiateOrder(Order order, Restaurant restaurant) {
        this.validateRestaurant(restaurant);
        this.setOrderProductInformation(order, restaurant);

        order.validateOrder();
        order.initializer();

        log.info("Order {} is created", order.getId());

        return new OrderCreateEvent(order, ZonedDateTime.now(ZoneId.of(UTC_ZONE)));
    }

    @Override
    public OrderPaidEvent payOrder(Order order) {
        order.pay();
        log.info("Order {} is paid", order.getId());

        return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of(UTC_ZONE)));
    }

    @Override
    public void approveOrder(Order order) {
        order.approve();
        log.info("Order {} is approved", order.getId());
    }

    @Override
    public OrderCancelEvent cancelOrderPayment(Order order, List<String> failureMessages) {
        order.initCancel(failureMessages);
        log.info("Order {} is cancelled", order.getId());

        return new OrderCancelEvent(order, ZonedDateTime.now(ZoneId.of(UTC_ZONE)));
    }

    @Override
    public void cancelOrder(Order order, List<String> failureMessages) {
        order.cancel(failureMessages);
        log.info("Order {} is cancelled", order.getId());
    }

    private void validateRestaurant(Restaurant restaurant) {
        if (!restaurant.isActive()) {
            throw new OrderDomainException("Restaurant is not active");
        }
    }

    private void setOrderProductInformation(Order order, Restaurant restaurant) {
        Map<ProductId, Product> restaurantProductsMap = restaurant.getProducts().stream()
                .collect(Collectors.toMap(Product::getId, Function.identity()));

        order.getOrderItems().forEach(orderItem -> {
            var currentProduct = orderItem.getProduct();
            var productId = currentProduct.getId();

            if (restaurantProductsMap.containsKey(productId)) {
                Product restaurantProduct = restaurantProductsMap.get(productId);
                currentProduct.updateWithConfirmedNameAndPrice(restaurantProduct.getName(),
                        restaurantProduct.getPrice());
            }
        });
    }

}
