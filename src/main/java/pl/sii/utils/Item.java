package pl.sii.utils;

import java.util.Objects;

public class Item {
    private final String itemName;
    private final int quantity;
    private final double price;

    public Item(String itemName, int stock, double price) {
        this.itemName = itemName;
        this.quantity = stock;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return quantity == item.quantity && Double.compare(item.price, price) == 0 && Objects.equals(itemName, item.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, quantity, price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
