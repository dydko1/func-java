package pl.sii.utils;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Order {
    private final UUID orderId;
    private final Customer customer;
    private List<LineItem> orderedItems;

    public Order(UUID orderId, Customer customer, List<LineItem> orderedItems) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderedItems = orderedItems;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<LineItem> getOrderedItems() {
        return orderedItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) && Objects.equals(customer, order.customer) && Objects.equals(orderedItems, order.orderedItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customer, orderedItems);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", orderedItems=" + orderedItems +
                '}';
    }
}
