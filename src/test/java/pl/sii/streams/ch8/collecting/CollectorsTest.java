package pl.sii.streams.ch8.collecting;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.sii.streams.Setup;
import pl.sii.utils.Order;
import pl.sii.utils.Shop;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
    // Collectors.toMap()
    // Collectors.collectingAndThen()
}
