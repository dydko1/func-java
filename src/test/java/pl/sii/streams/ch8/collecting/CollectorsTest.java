package pl.sii.streams.ch8.collecting;

import org.testng.annotations.Test;
import pl.sii.streams.Setup;
import pl.sii.utils.Order;
import pl.sii.utils.Shop;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsTest extends Setup {
    // forEach()
    @Test
    public void shouldPrintEashShop() {
        shops.forEach(System.out::println);
    }
    // toArray()
    @Test
    public void shouldCollectToRequiredCollection() {
        Set<String> setOfOrders = shops.stream().map(Shop::getName).collect(Collectors.toSet());
    }
    // collect()
    // Collectors.toList()
    // Collectors.toSet()
    // Collectors.toCollection()
    // Collectors.joining()
    // Collectors.toMap()
    // Collectors.collectingAndThen()
}
