package pl.sii.utils;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DataGenerator {
    private static final List<Item> generalListOfItems =  List.of(
            new Item("Super fun cup", 100, 5.00),
            new Item("Light oil", 200, 10.00),
            new Item("Super fun toys", 25, 2.00),
            new Item("Popular t-shirt", 200, 5.00),
            new Item("Plushy unicorn", 500, 1.00),
            new Item("Rubber duck", 100, 2.50),
            new Item("Candle", 300, 0.50),
            new Item("Lighter", 100, 10.00),
            new Item("Flashlight", 25, 12.50),
            new Item("Surprise box", 10, 5.35),
            new Item("Paint", 600, 1.00),
            new Item("Wheel", 100, 13.65)
    );
    private static final Map<String, Customer> customerMap = Map.of(
            "James", new Customer("James Smith", "jsmith@yahoo.com"),
            "Kathy", new Customer("Cathy May", "cmay@gmail.com"),
            "Adam", new Customer("Adam Blobber", "blobber@hotmail.com"),
            "John", new Customer("John Doe", "jd@gmail.com")
    );

    public static List<Shop> generateNewListOfShops() {
        return List.of(
                new Shop("James' Emporium", "21 Blue St. London",
                        generateEmporiumInventory(), generateEmporiumOrders()),
                new Shop("Waldo's Magical Stuff", "22 Yellow St. Liverpool",
                        generateWaldosInventory(), generateWaldosOrders()),
                new Shop("Bed, Bath & Beyond", "33 Stonks St. NY",
                        generateBbbInventory(), generateEmporiumOrders()),
                new Shop("Cool shop", "44 Cool St. NY",
                        generateCoolInventory(), generateEmporiumOrders())
        );
    }

    private static Inventory generateEmporiumInventory() {
        return new Inventory(List.of(generalListOfItems.get(0), generalListOfItems.get(1), generalListOfItems.get(2)));
    }

    private static List<Order> generateEmporiumOrders() {
        return List.of(
                new Order(UUID.randomUUID(), customerMap.get("James"), List.of(
                        new LineItem("Super fun cup", 1), new LineItem("Light oil", 2))),
                new Order(UUID.randomUUID(), customerMap.get("James"),
                        List.of(
                                new LineItem("Super fun toys", 1)))
        );
    }

    private static List<Order> generateWaldosOrders() {
        return List.of(
                new Order(UUID.randomUUID(), customerMap.get("Kathy"),
                        List.of(new LineItem("Popular t-shirt", 2))),
                new Order(UUID.randomUUID(), customerMap.get("James"),
                        List.of(new LineItem("Plushy unicorn", 5)))
        );
    }

    private static Inventory generateWaldosInventory() {
        return new Inventory(List.of(generalListOfItems.get(3), generalListOfItems.get(4), generalListOfItems.get(5)));
    }

    private static Inventory generateBbbInventory() {
        return new Inventory(List.of(generalListOfItems.get(6), generalListOfItems.get(7), generalListOfItems.get(8)));
    }

    private static Inventory generateCoolInventory() {
        return new Inventory(List.of(generalListOfItems.get(9), generalListOfItems.get(10), generalListOfItems.get(11)));
    }
}
