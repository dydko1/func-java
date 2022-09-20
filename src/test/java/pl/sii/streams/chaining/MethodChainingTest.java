package pl.sii.streams.chaining;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.sii.streams.Setup;
import pl.sii.utils.Item;
import pl.sii.utils.Order;
import pl.sii.utils.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MethodChainingTest extends Setup {
    @Test
    public void jamesShouldHaveOrders() {
        ArrayList<Item> jamesItems1 = new ArrayList<>();
        for (Shop s : shops) {
            for (Order o : s.getOrderList()) {
                if (o.getCustomer().getName().equals("James Smith")) {
                    for (Item jamesOrderedItem : o.getOrderedItems()) {
                        jamesItems1.add(jamesOrderedItem);
                    }
                }
            }
        }
        Assert.assertFalse(jamesItems1.isEmpty());

        List<Item> jamesItems2 = shops.stream()
                .flatMap(shop -> shop.getOrderList().stream())
                .filter(order -> order.getCustomer().getName().contains("James Smith"))
                .flatMap(jamesOrder -> jamesOrder.getOrderedItems().stream())
                .collect(Collectors.toList());
        Assert.assertFalse(jamesItems2.isEmpty());
    }
}
