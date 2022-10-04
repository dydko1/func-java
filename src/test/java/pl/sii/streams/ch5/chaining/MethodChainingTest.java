package pl.sii.streams.ch5.chaining;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.sii.streams.Setup;
import pl.sii.utils.LineItem;
import pl.sii.utils.Order;
import pl.sii.utils.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MethodChainingTest extends Setup {
    @Test
    public void jamesShouldHaveOrders() {
        ArrayList<LineItem> jamesItems1 = new ArrayList<>();
        for (Shop s : shops) {
            for (Order o : s.getOrderList()) {
                if (o.getCustomer().getName().equals("James Smith")) {
                    for (LineItem jamesOrderedItem : o.getOrderedItems()) {
                        jamesItems1.add(jamesOrderedItem);
                    }
                }
            }
        }
        Assert.assertFalse(jamesItems1.isEmpty());

        List<LineItem> jamesItems2 = shops.stream()
                .flatMap(shop -> shop.getOrderList().stream())
                .filter(order -> order.getCustomer().getName().contains("James Smith"))
                .flatMap(jamesOrder -> jamesOrder.getOrderedItems().stream())
                .collect(Collectors.toList());
        Assert.assertFalse(jamesItems2.isEmpty());
    }
}
