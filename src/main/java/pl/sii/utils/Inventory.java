package pl.sii.utils;

import java.util.List;
import java.util.Objects;

public class Inventory {
    private final List<Item> itemList;

    public Inventory(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(itemList, inventory.itemList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemList);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "itemList=" + itemList +
                '}';
    }
}
