package src.main.java.order_domain.core.entity;

import src.main.java.common.domain.entity.AggregateRoot;
import src.main.java.common.domain.valueobject.RestaurantId;

import java.util.List;

public class Restaurant extends AggregateRoot<RestaurantId> {

    private final List<Product> products;
    private boolean active;

    public Restaurant(List<Product> products) {
        this.products = products;
    }

    private Restaurant(Builder builder) {
        products = builder.products;
        active = builder.active;
        super.setId(builder.restaurantId);
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean isActive() {
        return active;
    }


    public static final class Builder {
        private RestaurantId restaurantId;
        private List<Product> products;
        private boolean active;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder restaurantId(RestaurantId val) {
            restaurantId = val;
            return this;
        }

        public Builder products(List<Product> val) {
            products = val;
            return this;
        }

        public Builder active(boolean val) {
            active = val;
            return this;
        }

        public Restaurant builder() {
            return new Restaurant(this);
        }
    }
}
