package pl.sii.streams.ch8.collecting;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.sii.streams.Setup;
import pl.sii.utils.Customer;
import pl.sii.utils.Order;
import pl.sii.utils.Shop;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsTest extends Setup {
    // forEach()
    @Test
    public void shouldPrintEashShop() {
        shops.forEach(System.out::println);
    }
    // toArray()
    // collect()
    // Collectors.toList()
    // Collectors.toSet()
    // Collectors.toCollection()
    @Test
    public void shouldCollectToRequiredCollection() {
        String[] arrayOfNames = shops.stream().map(Shop::getName).toArray(String[]::new);
        Assert.assertNotNull(arrayOfNames);
        List<String> listOfNames = shops.stream().map(Shop::getName).collect(Collectors.toList());
        Assert.assertNotNull(listOfNames);
        Set<String> setOfNames = shops.stream().map(Shop::getName).collect(Collectors.toSet());
        Assert.assertNotNull(setOfNames);
        LinkedList<String> concreteCollectionOfShopNames = shops.stream().map(Shop::getName)
                .collect(Collectors.toCollection(LinkedList::new));
        Assert.assertNotNull(concreteCollectionOfShopNames);
    }
    // Collectors.joining()
    // Collectors.collectingAndThen()
    @Test
    public void shouldJoinString() {
        String joinedString = shops.stream().flatMap(shop -> shop.getOrderList().stream().map(Order::getCustomer))
                .map(Customer::getName)
                .collect(Collectors.joining("/"));
//                .collect(Collectors.collectingAndThen(Collectors.toSet(), strings -> strings.stream().collect(Collectors.joining("/"))));
        System.out.println(joinedString);
    }
    // Collectors.toMap()
    @Test
    public void shouldCreateMap() {
        Map<String, List<Order>> shopPerOrderList = shops.stream()
                .collect(Collectors.toMap(Shop::getName, Shop::getOrderList));
        Assert.assertTrue(shopPerOrderList.containsKey("Bed, Bath & Beyond"));
        Assert.assertTrue(shopPerOrderList.get("Cool shop").size() > 0);
    }
}
