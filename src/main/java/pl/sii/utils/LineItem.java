package pl.sii.utils;

import java.util.List;
import java.util.Objects;

public class LineItem {
    private final String name;
    private final int quantity;

    public LineItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public static List<LineItem> nullLineItemList() {
        return List.of(new LineItem("Empty-name", 0));
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return Objects.equals(name, lineItem.name) && Objects.equals(quantity, lineItem.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity);
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
