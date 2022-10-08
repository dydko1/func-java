package pl.sii.utils;

import java.util.List;
import java.util.Objects;

public class Shop {
    private final String name;
    private final String address;
    private final Inventory inventory;
    private final List<Order> orderList;

    public Shop(String name, String address, Inventory inventory, List<Order> orderList) {
        this.name = name;
        this.address = address;
        this.inventory = inventory;
        this.orderList = orderList;
    }

    public static Shop nullShop() {
        System.out.println("Invoking null shop");
        return new Shop("Empty", "Empty", Inventory.nullInventory(), Order.nullOrderList());
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(name, shop.name) && Objects.equals(address, shop.address) && Objects.equals(inventory, shop.inventory) && Objects.equals(orderList, shop.orderList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, inventory, orderList);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", inventory=" + inventory +
                ", orderList=" + orderList +
                '}';
    }
}
