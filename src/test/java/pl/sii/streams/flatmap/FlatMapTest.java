package pl.sii.streams.flatmap;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.sii.streams.Setup;
import pl.sii.utils.Item;
import pl.sii.utils.Order;
import pl.sii.utils.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapTest extends Setup {
    @Test
    public void ordersShouldBeNonEmpty() {
        // Consider
        List<Order> allOrderList1 = new ArrayList<>();
        for (Shop s : shops) {
            for (Order o : s.getOrderList()) {
                allOrderList1.add(o);
            }
        }
        Assert.assertFalse(allOrderList1.isEmpty());

        // vs
        List<Order> allOrderList2 = shops.stream()
                .flatMap(shop -> shop.getOrderList().stream())
                .collect(Collectors.toList());
        Assert.assertFalse(allOrderList2.isEmpty());
    }

    @Test
    public void orderedItemsShouldBeNonEmpty() {
        // Consider
        List<Item> allOrderedItems1 = new ArrayList<>();
        for (Shop s : shops) {
            for (Order o : s.getOrderList()) {
                for (Item oi : o.getOrderedItems()) {
                    allOrderedItems1.add(oi);
                }
            }
        }
        Assert.assertFalse(allOrderedItems1.isEmpty());

        // vs
        List<Item> allOrderedItems2 = shops.stream()
                .flatMap(shop -> shop.getOrderList().stream()
                        .flatMap(order -> order.getOrderedItems().stream()))
                .collect(Collectors.toList());
        Assert.assertFalse(allOrderedItems2.isEmpty());
    }
}
