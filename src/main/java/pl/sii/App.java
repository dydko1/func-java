package pl.sii;

import pl.sii.utils.DataGenerator;
import pl.sii.utils.Shop;

import java.util.List;
import java.util.Spliterator;

public class App {
    public static void main(String[] args) {
        List<Shop> listOfShops = DataGenerator.generateNewListOfShops();
        listOfShops.forEach(System.out::println);
    }
}
